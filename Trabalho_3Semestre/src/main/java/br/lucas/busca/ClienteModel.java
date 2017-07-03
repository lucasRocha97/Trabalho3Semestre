package br.lucas.busca;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.lucas.cliente.Cliente;

public class ClienteModel extends AbstractTableModel{
	
	private List<Cliente> lista;
	
	void preencherCliente(List<Cliente> result){
		this.lista = result;
		
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		if(lista == null){
			return 0;
		}
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
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
		
		return null;
	}
	
	public Cliente getClienteAt(int idx){
		if(idx >= this.lista.size()){
			return null;
		}
		return lista.get(idx);
	}

}
