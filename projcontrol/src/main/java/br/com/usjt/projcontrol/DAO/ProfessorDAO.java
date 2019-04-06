package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Professor;

public class ProfessorDAO {

	Conexao conexao = null;
	String mensagem = "";
	Professor professorDados = null;
	
	
	public Professor loginProfessor(Professor professor) {
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "SELECT id, nome, email, senha FROM usuario WHERE email = ? AND senha = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, professor.getEmail());
			stmt.setString(2, professor.getSenha());
			ResultSet rs = stmt.executeQuery();
			professor = new Professor();
			while(rs.next()) {
				professor.setId(rs.getInt(1));
				professor.setNome(rs.getString("nome"));
				professor.setEmail(rs.getString("email"));
				professor.setSenha(rs.getString("senha"));
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			conexao.closeConexaoMYSQL();
		}
		
		return professorDados;
	}
	
	public void updateProfessor(Professor professor) {
		conexao = new Conexao();
		
		try (Connection conn = conexao.getConexaoMYSQL()){
			
			
			String sql = "UPDATE FROM usuario SET email = ?, senha = ? WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, professor.getEmail());
			stmt.setString(2,  professor.getSenha());
			stmt.setInt(3,professor.getId());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	public void deleteProfessor(int id) {
		conexao = new Conexao();
		
		try (Connection conn = conexao.getConexaoMYSQL()){
			

			String sql = "DELETE FROM aluno WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			
			try {
				String sqlProf = "DELETE FROM usuario WHERE id = ?";
				PreparedStatement stmtU = conn.prepareStatement(sqlProf);
				stmtU.setInt(1, id);
				stmtU.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			
			conexao.closeConexaoMYSQL();
		}
	}
	
	public int getProfessorID() {
		
		String sqlProfId = "SELECT id FROM usuario ORDER BY id DESC LIMIT 0,1";
		int usuarioId = 0;
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlProfId);
			
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					usuarioId = rs.getInt(1);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conexao.closeConexaoMYSQL();
		}
		return usuarioId;
	}
}
