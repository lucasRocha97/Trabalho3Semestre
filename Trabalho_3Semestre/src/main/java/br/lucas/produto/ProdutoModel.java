package br.lucas.produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProdutoModel extends AbstractTableModel {

	private List<Produto> lista;

	public ProdutoModel() {
		this((List<Produto>) null);

		for (int i = 0; i < 10; i++) {
			Produto p = new Produto();
			p.setId(i);
			p.setDescricao("Produto " + i);
			p.setValor(new BigDecimal("234442,89074" + i));
			this.lista.add(p);
			super.fireTableDataChanged();
		}
	}

	public ProdutoModel(List<Produto> listPro) {
		if(listPro == null){
			this.lista = new ArrayList<Produto>();
		}else{
			this.lista = listPro;
		}
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Id";
		case 1:
			return "Descrição";
		case 2:
			return "Valor";
		}

		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		Produto p = lista.get(row);

		switch (column) {
		case 0:
			return p.getId();
		case 1:
			return p.getDescricao();
		case 2:
			return p.getValor();
		}

		throw new RuntimeException("Coluna " + column + " solicitada não existe");

	}

	public void adicionar(Produto p) {
		this.lista.add(p);

		super.fireTableDataChanged();
	}

	public Produto getProduto(int idx) {
		return lista.get(idx);
	}

	public void remover(Produto produtoSelecionado) {
		this.lista.remove(produtoSelecionado);

		super.fireTableDataChanged();
	}

}
