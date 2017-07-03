package br.lucas.produto;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelProdutoBase extends JPanel {
	protected static final String CARREGADO_PARA_ALTERACAO = "Carregado para alteração";
	protected JTextField textId;
	protected JTextField textDescricao;
	protected JTextField textValor;
	protected JTable table;
	protected JLabel Carregar;
	protected JButton btnBuscar;

	/**
	 * Create the panel.
	 */
	public PainelProdutoBase() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);
		
		textId = new JTextField();
		
		textId = new JTextField();
//		textId.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_F2) {
//					abreBusca();
//				}
//			}
//		});
		
		GridBagConstraints gbc_textId = new GridBagConstraints();
		gbc_textId.anchor = GridBagConstraints.WEST;
		gbc_textId.insets = new Insets(0, 0, 5, 5);
		gbc_textId.gridx = 1;
		gbc_textId.gridy = 0;
		panel.add(textId, gbc_textId);
		textId.setColumns(13);
		
		Carregar = new JLabel("Carregado para altera\u00E7\u00E3o");
		GridBagConstraints gbc_Carregar = new GridBagConstraints();
		gbc_Carregar.anchor = GridBagConstraints.WEST;
		gbc_Carregar.insets = new Insets(0, 0, 5, 0);
		gbc_Carregar.gridx = 2;
		gbc_Carregar.gridy = 0;
		panel.add(Carregar, gbc_Carregar);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 1;
		panel.add(lblDescrio, gbc_lblDescrio);
		
		textDescricao = new JTextField();
		GridBagConstraints gbc_textDescricao = new GridBagConstraints();
		gbc_textDescricao.gridwidth = 2;
		gbc_textDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_textDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDescricao.gridx = 1;
		gbc_textDescricao.gridy = 1;
		panel.add(textDescricao, gbc_textDescricao);
		textDescricao.setColumns(10);
		
		JLabel lblValorR = new JLabel("Valor R$:");
		GridBagConstraints gbc_lblValorR = new GridBagConstraints();
		gbc_lblValorR.anchor = GridBagConstraints.EAST;
		gbc_lblValorR.insets = new Insets(0, 0, 0, 5);
		gbc_lblValorR.gridx = 0;
		gbc_lblValorR.gridy = 2;
		panel.add(lblValorR, gbc_lblValorR);
		
		textValor = new JTextField();
		GridBagConstraints gbc_textValor = new GridBagConstraints();
		gbc_textValor.insets = new Insets(0, 0, 0, 5);
		gbc_textValor.anchor = GridBagConstraints.WEST;
		gbc_textValor.gridx = 1;
		gbc_textValor.gridy = 2;
		panel.add(textValor, gbc_textValor);
		textValor.setColumns(13);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnBuscar = new JButton("Buscar(f2)");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		panel_1.add(btnBuscar, gbc_btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

}
