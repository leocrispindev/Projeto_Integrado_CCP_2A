package br.com.usjt.projcontrol.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static Connection conn = null;
	
	public Conexao() {
		
	}

	public static Connection getConexaoMYSQL() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String mydatabase = "projeto";
			String porta = "3306";
			String username = "root";  
			String password = "toor"; 
			String url = "jdbc:mysql://localhost:" + porta + "/" + mydatabase+ "?useTimezone=true&serverTimezone=UTC&useSSL=false";
				
			conn = DriverManager.getConnection(url, username, password);	
			
		}catch(ClassNotFoundException e) {
			System.out.println("Erro-->Driver n encontrado");
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;

	}
	
	public void closeConexaoMYSQL() {
		try {
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
