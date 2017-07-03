package br.lucas.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;

import br.lucas.cliente.Cliente;
import br.lucas.cliente.ClienteModel;
import br.lucas.db.ProdutoDao;

public class PainelProduto extends PainelProdutoBase {

	private Produto produtoSelecionado;
	private ProdutoModel modelo;

	ProdutoDao dao = new ProdutoDao();
	Produto p = new Produto();

	public PainelProduto() {
		super();
		configurarTablea();
		confirguraBotoes();
		limpar();
	}

	private void configurarTablea() {
		List<Produto> lista = dao.getTodos();

		this.modelo = new ProdutoModel(lista);
		super.table.setModel(modelo);
	}

	private void configuraTabela() {
		List<Produto> lista = dao.getTodos();

		this.modelo = new ProdutoModel(lista);
		super.table.setModel(modelo);

	}

	private void confirguraBotoes() {
		super.btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buscarPro();
			}
		});
	}

	protected void buscarPro() {
		// TODO Auto-generated method stub

	}

	protected void excluir() {
		this.modelo.remover(produtoSelecionado);

		limpar();
	}

	public void limpar() {
		super.Carregar.setText("");

		super.textId.setText("");
		super.textDescricao.setText("");
		super.textValor.setText("");

	}

}
