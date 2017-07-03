package br.lucas.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.function.Consumer;

import br.lucas.busca.PainelBuscaCli;
import br.lucas.db.ClienteDao;
import br.lucas.produto.Produto;

public class PainelCliente extends PainelClienteBase{
	
	private Cliente clienteSelecionado;
	private ClienteModel modelo;
	
	ClienteDao dao = new ClienteDao();
	Cliente c = new Cliente();
	
	public PainelCliente() {
		super();
		configuraTabela();
		confirguraBotoes();
		limpar();
	}

	private void configuraTabela() {
		List<Cliente> lista = dao.getTodos();
		
		this.modelo = new ClienteModel(lista);
		super.table.setModel(modelo);
		
		this.table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					int idx = table.getSelectedRow();
					
					if(idx < 0){
						System.out.println("Não há linha selecionada");
					}else{
						carregarLinha(idx);
					}
				}
				
			}
		});
	}

	protected void carregarLinha(int idx) {
		Cliente c = this.modelo.getCliente(idx);
		this.clienteSelecionado = c;
		this.Carregar.setText(CARREGADO_PARA_ALTERACAO);
		
		super.textId.setText(String.valueOf(c.getId()));
		super.textNome.setText(c.getNome());
		super.textCpf.setText(c.getCpf());
		
		super.btnExcluir.setEnabled(true);
	}

	private void confirguraBotoes() {
		super.btnNovo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		super.btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		super.btnExcluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		super.btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				abreBusca();
			}
		});
	}

	protected void abreBusca() {
		PainelBuscaCli pb = new PainelBuscaCli();
		pb.setOnOk(new Consumer<Cliente>() {

			@Override
			public void accept(Cliente t) {
				//getGlassPane().se
			}
		});
	}

	protected void excluir() {
		this.modelo.remover(clienteSelecionado);
		
		dao.excluir(clienteSelecionado);
		
		limpar();
	}

	protected void salvar() {
		if(clienteSelecionado == null){
			
			String strId = textId.getText().trim();
			String strNome = textNome.getText().trim();
			String strCpf = textCpf.getText().trim();
			
			int intId = Integer.parseInt(strId);
			
			c.setId(intId);
			c.setNome(strNome);
			c.setCpf(strCpf);
			
			this.modelo.adicionar(c);
			
			dao.inserir(c);
			
			limpar();
			
		}else{
			String strId = textId.getText().trim();
			String strNome = textNome.getText().trim();
			String strCpf = textCpf.getText().trim();
			
			int intId = Integer.parseInt(strId);
			
			this.clienteSelecionado.setId(intId);
			this.clienteSelecionado.setNome(strNome);
			this.clienteSelecionado.setCpf(strCpf);
			
			dao.atualizar(clienteSelecionado);
			
			limpar();
			
			this.modelo.fireTableDataChanged();
		}
		
	}
	
	protected void novo() {
		this.clienteSelecionado = null;
		limpar();
	}
	
	public void limpar(){
		super.Carregar.setText("");
		
		super.textId.setText("");
		super.textNome.setText("");
		super.textCpf.setText("");
		
		super.btnExcluir.setEnabled(false);
	}

}
