package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Professor;
import br.com.usjt.projcontrol.model.Usuario;

public class AlunoDAO {
	
	Conexao conexao = null;
	String mensagem = "";
	Aluno alunoDados = null;
	
	//=> Método para retorno de ID do Aluno pelas credenciais de acesso
	public Aluno loginAluno(Aluno aluno) {
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "SELECT usu.* FROM usuario usu INNER JOIN aluno al "
					+ "ON usu.id = al.aluno_ìd"
					+ "WHERE usu.email = ? AND usu.senha = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, aluno.getEmail());
			stmt.setString(2, aluno.getSenha());
			
			try(ResultSet rs = stmt.executeQuery()) {
				
				alunoDados = new Aluno();
				alunoDados.setId(rs.getInt(1));
				alunoDados.setNome(rs.getNString("nome"));
				alunoDados.setEmail(rs.getString("email"));
				alunoDados.setSenha(rs.getString("senha"));
				
			}catch(SQLException e) {
				System.out.println("Erro ao pegar ID");
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			conexao.closeConexaoMYSQL();
		}
		
		return alunoDados;
	}
	
	
	public void cadastrarAluno(Aluno aluno) {
		
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {
			
			//=>Realiza o INSERT na tabela de Usuario
			String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setString(3, aluno.getSenha());
			stmt.execute();
			
			//=> Caso ocorra o INSERT em Usuario 
			//=> O processo seguinte é tentar o insert em Aluno
			try {
				
				//=>Método que retorna o ultimo ID inserido na tabela de Usuario
				int usuID = this.getUsuarioID();
				
				//=>Insert na tabela de Aluno
				String insertAluno = "INSERT INTO aluno (aluno_id, ra) VALUES (?,?)";
				 
				PreparedStatement stmtAluno = conn.prepareStatement(sql);
				stmtAluno.setInt(1, usuID);
				stmtAluno.setInt(2, aluno.getRa());
				stmtAluno.execute();
								
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			conexao.closeConexaoMYSQL();
		}
		
	}
	
	public void updateAluno(Aluno aluno) {
		conexao = new Conexao();
		
		try (Connection conn = conexao.getConexaoMYSQL()){
			
			//=> Query para update de dados do Aluno
			String sql = "UPDATE FROM usuario SET email = ?, senha = ? WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getEmail());
			stmt.setString(2,  aluno.getSenha());
			stmt.setInt(3,aluno.getId());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	public void deleteAluno(int id) {
		conexao = new Conexao();
		
		try (Connection conn = conexao.getConexaoMYSQL()){
			
			//=> Query para update de dados do Aluno
			String sql = "DELETE FROM aluno WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			
			try {
				String sqlUsuario = "DELETE FROM usuario WHERE id = ?";
				PreparedStatement stmtU = conn.prepareStatement(sqlUsuario);
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
	

	private int getUsuarioID() {
		
		String sqlRetornaIDUsuario = "SELECT id FROM usuario ORDER BY id DESC LIMIT 0,1";
		int usuID = 0;
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlRetornaIDUsuario);
			
			try(ResultSet rs = stmt.executeQuery()) {
				usuID = rs.getInt(1);
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conexao.closeConexaoMYSQL();
		}
		
		return usuID;
	}
	
	
	
	
	
	
	
	
	
	
	
}
