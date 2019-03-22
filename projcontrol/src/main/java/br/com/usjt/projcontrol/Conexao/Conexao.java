package br.com.usjt.projcontrol.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static Connection conn = null;
	
	public Conexao() {

	}

	public static Connection getConexaoMYSQL() throws SQLException{
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String serverName = "localhost"; 
		String mydatabase = "projeto";
		String porta = "3306";
		String username = "root";  
		String password = "root"; 
		;;String url = "jdbc:mysql://" + serverName +":" + porta + "/" + mydatabase+ "?useTimezone=true&serverTimezone=UTC";
			
		conn = DriverManager.getConnection(url, username, password);	
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
