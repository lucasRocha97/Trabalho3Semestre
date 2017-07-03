//package br.lucas.db;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public final class ConexaoDBProduto {
//	
//	private static ConexaoDBProduto self;
//	private Connection con;
//	
//	private ConexaoDBProduto() {
//		
//		try {
//
//			Class.forName("org.postgresql.Driver");
//			this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cliente", "postgres", "lucas");
//			
//			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//				
//				public void run() {
//					try {
//					
//						ConexaoDBProduto.this.con.close();
//					
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}));
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public final static synchronized ConexaoDB getInstance(){
//		if(self == null){
//			self = new ConexaoDB();
//		}
//		return self;
//	}
//	
//	public Connection getConnection(){
//		return this.con;
//	}
//	
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		throw new CloneNotSupportedException("Só haver um");
//	}
//	
//}
