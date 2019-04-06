package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.usjt.projcontrol.Conexao.Conexao;

public class GrupoDAO {

	Conexao conexao = null;
	String mensagem = "";

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
