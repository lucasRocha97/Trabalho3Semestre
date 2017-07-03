package br.lucas.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.lucas.cliente.Cliente;

public class ClienteDao {

	private static final String SQL_BUSCA_TODOS = "SELECT * FROM CLIENTES";
	private Connection con;
	private PreparedStatement ps;
	private String strSql;
	private StringBuilder sb;
	
	public List<Cliente> getTodos(){
		con = ConexaoDB.getInstance().getConnection();
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		try(PreparedStatement ps = con.prepareStatement(SQL_BUSCA_TODOS); ResultSet rs = ps.executeQuery()){
			
			while(rs.next()){
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				
				lista.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}
	
	public void inserir(Cliente c){
		con = ConexaoDB.getInstance().getConnection();
		
		sb = new StringBuilder();
		
		sb.append("INSERT INTO clientes (id, nome, cpf) VALUES (" + c.getId() + ", '" + c.getNome() + "', '" + 
		c.getCpf() + "')");
		
		strSql = sb.toString();
		System.out.println(strSql);
		
		try {
		
			ps = con.prepareStatement(strSql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Cliente c){
		con = ConexaoDB.getInstance().getConnection();
		
		sb = new StringBuilder();
		sb.append("UPDATE clientes SET nome = '" + c.getNome() + "' WHERE id = " + c.getId());
		strSql = sb.toString();
		
		System.out.println(strSql);
		
		try {
		
			ps = con.prepareStatement(strSql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Cliente c){
		con = ConexaoDB.getInstance().getConnection();
		
		sb = new StringBuilder();
		sb.append("DELETE FROM clientes WHERE id = " + c.getId());
		strSql = sb.toString();
		
		System.out.println(strSql);
		
		try {
		
			ps = con .prepareStatement(strSql);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
