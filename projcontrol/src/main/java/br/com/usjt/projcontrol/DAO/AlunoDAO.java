package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Professor;
import br.com.usjt.projcontrol.model.Tema;
import br.com.usjt.projcontrol.model.Turma;

public class AlunoDAO {
	
	Conexao conexao = null;
	String mensagem = "";
	Aluno alunoDados = null;
	
	//=> Método para retorno de ID do Aluno pelas credenciais de acesso
	public Aluno loginAluno(Aluno aluno) {
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "SELECT usu.id, al.ra, usu.nome, usu.email, usu.senha FROM usuario usu "
					+ "INNER JOIN aluno al ON usu.id = al.aluno_id "
					+ " WHERE usu.email = ? AND usu.senha = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getEmail());
			stmt.setString(2, aluno.getSenha());
			ResultSet rs = stmt.executeQuery();
			alunoDados = new Aluno();
			while(rs.next()) {
			
				alunoDados.setId(rs.getInt(1));
				alunoDados.setRa(rs.getInt("ra"));
				alunoDados.setNome(rs.getString("nome"));
				alunoDados.setEmail(rs.getString("email"));
				alunoDados.setSenha(rs.getString("senha"));
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
				 
				PreparedStatement stmtAluno = conn.prepareStatement(insertAluno);
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
		
		try (Connection conn = Conexao.getConexaoMYSQL()){
			
			//=> Query para update de dados do Aluno
			String sql = "UPDATE usuario SET email = ?, senha = ? WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getEmail());
			stmt.setString(2,  aluno.getSenha());
			stmt.setInt(3,aluno.getId());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
}
	
	public boolean deleteAluno(int id) {
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()){
			
			//=> Query para update de dados do Aluno
			String sql = "DELETE FROM aluno WHERE aluno_id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			
			try {
				String sqlUsuario = "DELETE FROM usuario WHERE id = ?";
				PreparedStatement stmtU = conn.prepareStatement(sqlUsuario);
				stmtU.setInt(1, id);
				stmtU.execute();
				
				return true;
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			
			conexao.closeConexaoMYSQL();
		}
		return false;
	}
	

	public int getUsuarioID() {
		
		String sqlRetornaIDUsuario = "SELECT id FROM usuario ORDER BY id DESC LIMIT 0,1";
		int usuarioID = 0;
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlRetornaIDUsuario);
			
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					usuarioID = rs.getInt(1);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conexao.closeConexaoMYSQL();
		}
		return usuarioID;
	}
	
	public ArrayList<Turma> getTurmasByAlunoID(int id) {
		
		String sql = "SELECT t.sigla, tm.titulo, tm.introducao FROM turma_aluno aluno "
				+ "INNER JOIN turma t ON t.id = aluno.turma_id "
				+ "INNER JOIN tema tm ON tm.id = t.id "
				+ " WHERE aluno.aluno_id = ?";
		
		ArrayList<Turma> arrayTurmas = null;
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			arrayTurmas = new ArrayList<Turma>();
			try(ResultSet result = stmt.executeQuery()) {
				
				while(result.next()) {
					
					Tema tema = new Tema();
					tema.setTitulo(result.getString(2));
					tema.setIntroducao(result.getString(3));
					
					Turma turma = new Turma();
					turma.setSigla(result.getString(1));
					turma.setTurmaTema(tema);
				
					arrayTurmas.add(turma);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conexao.closeConexaoMYSQL();
		}
		
		return arrayTurmas;
	}
	
	public ArrayList<Aluno> getAllAlunos() {
		String sql = "select a.ra, u.nome, u.email, u.id from aluno a inner join usuario u on a.aluno_id = u.id;";
		
		ArrayList<Aluno> arrayAlunos = new ArrayList<>();
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Aluno aluno = new Aluno();
					aluno.setId(rs.getInt("id"));
					aluno.setRa(rs.getInt(1));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					
					arrayAlunos.add(aluno);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayAlunos;
	}
	
	
	public Aluno getDadosAlunoById(int id) {
		conexao = new Conexao();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "SELECT usu.id, al.ra, usu.nome, usu.email, usu.senha FROM usuario usu "
					+ "INNER JOIN aluno al ON usu.id = al.aluno_id "
					+ " WHERE al.aluno_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			alunoDados = new Aluno();
			
			while(rs.next()) {
			
				alunoDados.setId(rs.getInt(1));
				alunoDados.setRa(rs.getInt("ra"));
				alunoDados.setNome(rs.getString("nome"));
				alunoDados.setEmail(rs.getString("email"));
				alunoDados.setSenha(rs.getString("senha"));
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			conexao.closeConexaoMYSQL();
		}
		
		return alunoDados;
	}
	
	public ArrayList<Grupo> getGruposByAlunoId(int id) {
		String sql = "SELECT u.nome, g.id, u.id, g.nome, g.numero FROM aluno a "
				+ "INNER JOIN turma_aluno ta ON a.aluno_id = ta.Aluno_id "
				+ "INNER JOIN grupo g ON g.id = ta.grupo_id "
				+ "INNER JOIN professor p ON g.orientador_id = p.professor_id "
				+ "INNER JOIN usuario u ON p.professor_id = u.id WHERE a.aluno_id = ?;";
		
		ArrayList<Grupo> arrayGrupos = new ArrayList<>();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Grupo grupo = new Grupo();
					grupo.setNome(rs.getString("g.nome"));
					grupo.setNumero_grupo(rs.getInt("g.numero"));
					grupo.setId(rs.getInt("g.id"));
					Professor professor = new Professor();
					professor.setNome(rs.getString("u.nome"));
					professor.setId(rs.getInt("u.id"));
					grupo.setProfessor(professor);
					
					arrayGrupos.add(grupo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayGrupos;
	}
	
	public ArrayList<Aluno> getAlunosByGrupoId(int id) {
		String sql = "SELECT a.ra, u.nome FROM aluno a "
				+ "INNER JOIN usuario u ON a.aluno_id = u.id "
				+ "INNER JOIN turma_aluno ta ON a.aluno_id = ta.Aluno_id "
				+ "INNER JOIN grupo g ON ta.grupo_id = g.id WHERE g.id = ?;";
		
		ArrayList<Aluno> arrayAlunos = new ArrayList<>();
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Aluno aluno = new Aluno();
					aluno.setNome(rs.getString("u.nome"));
					aluno.setRa(rs.getInt("a.ra"));
					arrayAlunos.add(aluno);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayAlunos;
	}
}

