package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Professor;
import br.com.usjt.projcontrol.model.Turma;

public class TurmaDAO {

	private Conexao conexao = null;
	private String mensagem = "";

	public void cadastrarTurma(Turma turma) {

		conexao = new Conexao();

		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "INSERT INTO turma (codigoIdentificador, anoLetivo, alunos) VALUES (?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, turma.getCodigoIdentificador());
			stmt.setInt(2, turma.getAnoLetivo());
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
			stmt.setInt(2, turma.getAnoLetivo());
			stmt.setObject(3, turma.getAlunos());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	}

	public void getTurmaId() {

		String sqlTurmaId = "SELECT codigoIdentificador FROM turma ORDER BY codigoIdentificador";

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlTurmaId);

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	}
	
	public ArrayList<Turma> getTurmas() {
		String sql = "SELECT semestre_letivo, ano_letivo FROM turma;";
		ArrayList<Turma> arrayTurmas = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Turma turma = new Turma();
					turma.setSemestreLetivo(rs.getInt("semestre_letivo"));
					turma.setAnoLetivo(rs.getInt("ano_letivo"));
					arrayTurmas.add(turma);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayTurmas;
	}

}
