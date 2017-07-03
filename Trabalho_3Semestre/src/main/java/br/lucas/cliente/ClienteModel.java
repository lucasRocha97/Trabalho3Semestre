package br.lucas.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ClienteModel extends AbstractTableModel{

	private List<Cliente> lista;
	
	public ClienteModel() {
		this((List<Cliente>)null);
		
		for(int i = 0; i < 10; i++){
			Cliente c = new Cliente();
			c.setId(i);
			c.setNome("Cliente " + i);
			c.setCpf("234442 - 4" + i);
			this.lista.add(c);
			super.fireTableDataChanged();
		}
	}
	
	public ClienteModel(List<Cliente> _list) {
		if(_list == null){
			this.lista = new ArrayList<Cliente>();
		}else{
			this.lista = _list;
		}
	}

	public int getRowCount() {
		return lista.size();
	}

	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		switch (column){
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Cpf";
		}
		
		return super.getColumnName(column);
	}

	public Object getValueAt(int row, int column) {
		Cliente c = lista.get(row);
		
		switch(column){
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getCpf();
		}
		
		throw new RuntimeException("Coluna " + column + " solicitada não existe");
	}
	
	public void adicionar(Cliente c){
		this.lista.add(c);
		
		super.fireTableDataChanged();
	}
	
	public Cliente getCliente(int idx){
		return lista.get(idx);
	}
	
	public void remover(Cliente clienteSelecionado){
		this.lista.remove(clienteSelecionado);
		
		super.fireTableDataChanged();
	}

}
