package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Professor;

public class GrupoDAO {

	private Conexao conexao = null;
	private String mensagem = "";

	public ArrayList<Grupo> getGruposByAlunoID(int id) {

		String sql = "SELECT " + 
				"    a.ra 'ra' , " + 
				"    ua.nome 'nome_aluno', " + 
				"    g.numero 'num_grupo', " + 
				"    g.nome 'nome_grupo', " + 
				"    u.id 'id_orientador', " +
				"    u.nome 'nome_orientador' " + 
				"FROM" + 
				"    grupo g " + 
				"        INNER JOIN " + 
				"    professor p ON p.professor_id = g.orientador_id " + 
				"        INNER JOIN " + 
				"    usuario u ON u.id = p.professor_id " + 
				"        INNER JOIN " + 
				"    turma_aluno ta ON ta.grupo_id = g.id " + 
				"        INNER JOIN " + 
				"    aluno a ON a.aluno_id = ta.Aluno_id " + 
				"        INNER JOIN " + 
				"    usuario ua ON ua.id = a.aluno_id " + 
				"WHERE " + 
				"    a.aluno_id = ? " + 
				"ORDER BY g.numero;";

		ArrayList<Grupo> arrayGruposDoAluno = new ArrayList<Grupo>();
		conexao = new Conexao();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					Grupo grupo = new Grupo();
					grupo.setNome(rs.getString("nome_grupo"));
					grupo.setNumero_grupo(rs.getInt("num_grupo"));

					Professor professor = new Professor();
					professor.setId(rs.getInt("id_orientador"));
					grupo.setProfessor(professor);

					arrayGruposDoAluno.add(grupo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conexao.closeConexaoMYSQL();
		}
		return arrayGruposDoAluno;
	}

	public ArrayList<Grupo> getGrupos() {
		String sql = "SELECT g.*, p.administrador, p.professor_id, p.matricula, u.nome "
				+ "FROM grupo g INNER JOIN professor p ON g.id = p.professor_id "
				+ "INNER JOIN usuario u ON u.id = p.professor_id;";
		ArrayList<Grupo> arrayGrupos = new ArrayList<>();

		try(Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {

				Professor professor = new Professor();
				professor.setId(rs.getInt("professor_id"));
				professor.setNome(rs.getString("nome"));
				professor.setAdm(rs.getBoolean("administrador"));
				professor.setMatricula(rs.getInt("matricula"));

				Grupo grupo = new Grupo();
				grupo.setNome(rs.getString("nome"));
				grupo.setNumero_grupo(rs.getInt("numero"));
				grupo.setProfessor(professor);

				arrayGrupos.add(grupo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.closeConexaoMYSQL();
		}

		return arrayGrupos;
	}

	public void getGrupoId() {

		String sqlGrupoId = "SELECT id FROM grupo ORDER BY id DESC LIMIT 0,1";

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlGrupoId);

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	}
}
