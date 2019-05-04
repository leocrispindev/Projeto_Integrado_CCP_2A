package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Professor;
import br.com.usjt.projcontrol.model.Turma;

public class GrupoDAO {

	public ArrayList<Grupo> getGruposByAluno(Aluno aluno, int ano, int semestre) {

		String sql = "SELECT g.numero, g.nome, u.nome, u.id, t.semestre_letivo, t.ano_letivo FROM aluno a "
				+ "INNER JOIN turma_aluno ta ON a.aluno_id = ta.Aluno_id "
				+ "INNER JOIN turma t ON ta.turma_id = t.id "
				+ "INNER JOIN grupo g ON g.id = ta.grupo_id "
				+ "INNER JOIN professor p ON g.orientador_id = p.professor_id "
				+ "INNER JOIN usuario u ON p.professor_id = u.id "
				+ "WHERE a.aluno_id = ? and t.semestre_letivo = ? and t.ano_letivo = ?;";

		ArrayList<Grupo> arrayGruposDoAluno = new ArrayList<Grupo>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, aluno.getId());
			stmt.setInt(2, semestre);
			stmt.setInt(3, ano);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					Grupo grupo = new Grupo();
					grupo.setNome(rs.getString("g.nome"));
					grupo.setNumero_grupo(rs.getInt("g.numero"));

					Professor professor = new Professor();
					professor.setNome(rs.getString("u.nome"));
					professor.setId(rs.getInt("u.id"));
					grupo.setProfessor(professor);

					arrayGruposDoAluno.add(grupo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arrayGruposDoAluno;
	}

	public ArrayList<Grupo> getGrupos() {
		String sql = "SELECT g.*, p.administrador, p.professor_id, p.matricula, u.nome "
				+ "FROM grupo g INNER JOIN professor p ON g.id = p.professor_id "
				+ "INNER JOIN usuario u ON u.id = p.professor_id;";
		ArrayList<Grupo> arrayGrupos = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {

					Professor professor = new Professor();
					professor.setId(rs.getInt("p.professor_id"));
					professor.setNome(rs.getString("u.nome"));
					professor.setAdm(rs.getBoolean("p.administrador"));
					professor.setMatricula(rs.getInt("p.matricula"));

					Grupo grupo = new Grupo();
					grupo.setNome(rs.getString("g.nome"));
					grupo.setNumero_grupo(rs.getInt("g.numero"));
					grupo.setProfessor(professor);

					arrayGrupos.add(grupo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayGrupos;
	}
	
	public ArrayList<Grupo> getGruposByTurmaId(Turma turma) {
		String sql = "SELECT g.id, g.nome FROM grupo g "
				+ "INNER JOIN turma_aluno ta ON ta.grupo_id = g.id "
				+ "INNER JOIN turma t ON t.id = ta.turma_id WHERE t.id = ?;";
		ArrayList<Grupo> arrayGrupos = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, turma.getCodigoIdentificador());
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Grupo grupo = new Grupo();
					grupo.setId(rs.getInt("g.id"));
					grupo.setNome(rs.getString("g.nome"));
					arrayGrupos.add(grupo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayGrupos;
	}
	
	public int getGrupoId() {

		String sqlGrupoId = "SELECT id FROM grupo ORDER BY id DESC LIMIT 0,1";
		int grupoId = 0;

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlGrupoId);
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs.next())
					grupoId = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grupoId;
	}
}
