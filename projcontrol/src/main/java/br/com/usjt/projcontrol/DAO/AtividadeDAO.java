package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.usjt.projcontrol.Conexao.Conexao;

public class AtividadeDAO {

	Conexao conexao = null;
	String mensagem = "";

	public void getAtividadeId() {

		String sqlAtividadeId = "SELECT id FROM atividade ORDER BY id DESC LIMIT 0,1";

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlAtividadeId);

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	}
}
