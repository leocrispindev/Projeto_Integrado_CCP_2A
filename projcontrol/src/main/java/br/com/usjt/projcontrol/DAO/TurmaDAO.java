package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Turma;

public class TurmaDAO {

	Conexao conexao = null;
	String mensagem = "";

	public void cadastrarTurma(Turma turma) {

		conexao = new Conexao();

		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "INSERT INTO turma (codigoIdentificador, anoLetivo, alunos) VALUES (?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, turma.getCodigoIdentificador());
			stmt.setDate(2, (Date) turma.getAnoLetivo());
			stmt.setObject(3, turma.getAlunos());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	}

	public void deleteTurma(Turma turma) {

		conexao = new Conexao();

		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "DELETE FROM turma WHERE codigoIdentificador = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, turma.getCodigoIdentificador());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	}

	public void updateTurma(Turma turma) {
		conexao = new Conexao();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			String sql = "UPDATE FROM usuario SET email = ?, senha = ? WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, turma.getCodigoIdentificador());
			stmt.setDate(2, (Date) turma.getAnoLetivo());
			stmt.setObject(3, turma.getAlunos());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	}

	public void getTurma() {

		String sqlListaTurma = "SELECT codigoIdentificador FROM turma ORDER BY codigoIdentificador";

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlListaTurma);

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	}

}
