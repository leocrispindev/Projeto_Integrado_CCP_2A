package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Turma;

public class TurmaDAO {

	private Conexao conexao = null;
	private String mensagem = "";

	public void cadastrarTurma(Turma turma) {

		conexao = new Conexao();

		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "INSERT INTO turma (codigoIdentificador, anoLetivo, alunos) VALUES (?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, turma.getCodigoIdentificador());
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

			stmt.setInt(1, turma.getCodigoIdentificador());
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

			stmt.setInt(1, turma.getCodigoIdentificador());
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
	
	public ArrayList<Turma> getPeriodoLetivo() {
		ArrayList<Turma> arrayAno = new ArrayList<Turma>();
		String sql = "SELECT DISTINCT ano_letivo FROM turma t ORDER BY ano_letivo DESC;";

		try (Connection conn = Conexao.getConexaoMYSQL()) {

			PreparedStatement stmt = conn.prepareStatement(sql);
			try(ResultSet rs = stmt.executeQuery();){
				while (rs.next()) {
					Turma t = new Turma();
					t.setAnoLetivo(rs.getInt("ano_letivo"));
					arrayAno.add(t);	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return arrayAno;
	}
	
	public ArrayList<Turma> getPeriodoLetivoByAlunoId(Aluno aluno) {
		ArrayList<Turma> arrayAno = new ArrayList<Turma>();
		String sql = "SELECT DISTINCT ano_letivo, semestre_letivo FROM aluno a "
				+ "INNER JOIN turma_aluno ta ON ta.Aluno_id = a.aluno_id "
				+ "INNER JOIN turma t ON ta.turma_id = t.id "
				+ "WHERE a.aluno_id = ? ORDER BY ano_letivo DESC;";

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, aluno.getId());
			try(ResultSet rs = stmt.executeQuery();){
				while (rs.next()) {
					Turma t = new Turma();
					t.setAnoLetivo(rs.getInt("ano_letivo"));
					t.setSemestreLetivo(rs.getInt("semestre_letivo"));
					arrayAno.add(t);	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return arrayAno;
	}
	
	public ArrayList<Turma> getTurmasByPeriodo(Turma turma) {
		String sql = "SELECT id, sigla FROM turma where semestre_letivo = ? AND ano_letivo = ?;";
		ArrayList<Turma> arrayTurmas = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, turma.getSemestreLetivo());
			stmt.setInt(2, turma.getAnoLetivo());
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Turma t = new Turma();
					t.setSigla(rs.getString("sigla"));
					t.setCodigoIdentificador(rs.getInt("id"));
					arrayTurmas.add(t);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayTurmas;
	}

}
