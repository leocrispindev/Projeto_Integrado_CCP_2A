package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.RecuperarSenha;

public class CredenciaisDAO {
	Conexao conexao = null;

	public void updateCredenciais(String campo, int id, String sql) {
		conexao = new Conexao();

		try (Connection conn = conexao.getConexaoMYSQL()) {

			// => Query para update de dados do Aluno
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, campo);
			stmt.setInt(2, id);
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void getSenhaPorEmail(RecuperarSenha r1) {

		Conexao conexao = null;

		conexao = new Conexao();

		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "SELECT senha,nome FROM usuario WHERE email = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, r1.getEmail());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				r1.setSenha(rs.getString("senha"));
				r1.setNome(rs.getString("nome"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.closeConexaoMYSQL();
		}

	}
}
