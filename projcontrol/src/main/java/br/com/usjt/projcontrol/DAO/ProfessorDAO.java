package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Professor;

public class ProfessorDAO {

	Conexao conexao = null;
	String mensagem = "";
	Professor professorDados = null;
	
	
	public Professor loginProfessor(Professor professor) {
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "SELECT usu.id, usu.nome, usu.email, usu.senha FROM usuario usu "
					+ "INNER JOIN professor p ON usu.id = p.professor_id "
					+ " WHERE usu.email = ? AND usu.senha = ? AND p.administrador = 1;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, professor.getEmail());
			stmt.setString(2, professor.getSenha());
			ResultSet rs = stmt.executeQuery();
			professorDados = new Professor();
			
			while(rs.next()) {
				professorDados.setId(rs.getInt(1));
				professorDados.setNome(rs.getString("nome"));
				professorDados.setEmail(rs.getString("email"));
				professorDados.setSenha(rs.getString("senha"));
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
			
			
			String sql = "UPDATE usuario SET email = ?, senha = ? WHERE id = ?";
			
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
			

			String sql = "DELETE FROM professor WHERE professor_id = ?";
			
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
	
	public ArrayList<Professor> getProfessores() {
		String sql = "SELECT p.professor_id, u.nome FROM professor p INNER JOIN usuario u ON p.professor_id = u.id;";
		ArrayList<Professor> arrayProfessores = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Professor professor = new Professor();
					professor.setId(rs.getInt("professor_id"));
					professor.setNome(rs.getString("nome"));
					arrayProfessores.add(professor);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayProfessores;
	}
	
	public ArrayList<Professor> getProfessoresByPeriodo(int ano, int semestre) {
		String sql = "SELECT DISTINCT p.professor_id, u.nome FROM professor p "
				+ "INNER JOIN usuario u ON p.professor_id = u.id "
				+ "INNER JOIN grupo g ON g.orientador_id = p.professor_id " 
				+ "INNER JOIN turma_aluno ta ON ta.grupo_id = g.id "
				+ "INNER JOIN turma t ON t.id = ta.turma_id "
				+ "WHERE t.ano_letivo = ? AND t.semestre_letivo = ?;";
		
		ArrayList<Professor> arrayProfessores = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ano);
			stmt.setInt(2, semestre);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Professor professor = new Professor();
					professor.setId(rs.getInt("p.professor_id"));
					professor.setNome(rs.getString("u.nome"));
					arrayProfessores.add(professor);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayProfessores;
	}
}
