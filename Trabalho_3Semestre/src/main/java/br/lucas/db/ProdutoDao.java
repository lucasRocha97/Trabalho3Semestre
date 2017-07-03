package br.lucas.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.lucas.produto.BuscaProdutoUrl;
import br.lucas.produto.Produto;

public class ProdutoDao {
	private static final String SQL_BUSCA_TODOS = "SELECT * FROM PRODUTOS";
	private Connection con;
	private PreparedStatement ps;
	private String strSql;
	private StringBuilder sb;

	BuscaProdutoUrl bus = new BuscaProdutoUrl();

	public List<Produto> getTodos() {
		con = ConexaoDB.getInstance().getConnection();

		List<Produto> lista = new ArrayList<Produto>();

		try (PreparedStatement ps = con.prepareStatement(SQL_BUSCA_TODOS); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setDescricao(rs.getString("descricao"));
				p.setValor(rs.getBigDecimal("valor"));

				lista.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public void inserir(Produto p) throws Exception {
		con = ConexaoDB.getInstance().getConnection();
		List<Produto> lista = bus.lerProdutos("");

		for (int i = 0; i < lista.size(); i++) {
			sb = new StringBuilder();
			
			sb.append("INSERT INTO produtos (id, descricao, valor) VALUES (" + lista.get(i).getId() + 
					", '" + lista.get(i).getDescricao() + "', " + lista.get(i).getValor() + ")");
			
			strSql = sb.toString();
			
			try {

				ps = con.prepareStatement(strSql);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(strSql);

	}

}
