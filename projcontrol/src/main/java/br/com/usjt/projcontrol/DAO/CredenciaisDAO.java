package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Aluno;

public class CredenciaisDAO {
	Conexao conexao = null;
	
	public void updateCredenciais(String campo, int id, String sql) {
		conexao = new Conexao();
		
		try (Connection conn = conexao.getConexaoMYSQL()){
			
			//=> Query para update de dados do Aluno
		
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, campo);
			stmt.setInt(2, id);
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
	}
}
