package br.lucas.busca;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import br.lucas.cliente.Cliente;
import br.lucas.db.ClienteDao;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelBuscaCli extends JPanel {
	private JTextField textField;
	private JTable table;
	private Consumer<Cliente> consumerOnOk;
	private Runnable runnableOnCancel;

	/**
	 * Create the panel.
	 */
	public PainelBuscaCli() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNomeCliente = new JLabel("Nome cliente");
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.insets = new Insets(0, 0, 5, 0);
		gbc_lblNomeCliente.anchor = GridBagConstraints.WEST;
		gbc_lblNomeCliente.gridx = 0;
		gbc_lblNomeCliente.gridy = 0;
		add(lblNomeCliente, gbc_lblNomeCliente);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

	}

	private void configuraTela(){
		ClienteModel cModel = new ClienteModel();
		table.setModel(cModel);
		
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				switch(e.getKeyCode()){
				case KeyEvent.VK_DOWN:
					table.getSelectionModel().setSelectionInterval(0, 0);
					textField.transferFocus();
					return;
				case KeyEvent.VK_ESCAPE:
					if (PainelBuscaCli.this.runnableOnCancel != null) {
						PainelBuscaCli.this.runnableOnCancel.run();
					}
					return;
				default:
					busca(textField.getText().trim().toLowerCase());
				}
				
			}
		});
		
		table.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					table.transferFocusBackward();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					// Pra cancelar a ação padrão que já existe
					// na JTable com a tecla Enter.
					e.consume();
					
					int idx = table.getSelectedRow();
					if (idx != -1) {
						Cliente cli = ((ClienteModel)table.getModel()).getClienteAt(idx);
						if (cli == null) {
							return;
						}
						PainelBuscaCli.this.consumerOnOk.accept(cli);
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelBuscaCli.this.runnableOnCancel != null) {
						PainelBuscaCli.this.runnableOnCancel.run();
					}
				}
			}
		});
	}

	protected void busca(String palavra) {
		ClienteDao dao = new ClienteDao();
		
		List<Cliente> lista = dao.getTodos();

		((ClienteModel) table.getModel()).preencherCliente(lista);

	}
	
	public void setOnOk(Consumer<Cliente> c) {
		this.consumerOnOk = c;
	}

	public void setOnCancel(Runnable r) {
		this.runnableOnCancel = r;
	}

	@Override
	public void setVisible(boolean arg0) {
		
		super.setVisible(arg0);
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				textField.requestFocusInWindow();
			}
		});
	}

}
