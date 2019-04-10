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

	Conexao conexao = null;
	String mensagem = "";
	
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
