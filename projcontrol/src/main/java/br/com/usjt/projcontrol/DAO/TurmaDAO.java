package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Tema;
import br.com.usjt.projcontrol.model.Turma;

public class TurmaDAO {

	private Conexao conexao = null;
	private String mensagem = "";

	public void cadastrarTurma(Turma turma) {
		
		conexao = new Conexao();

		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "INSERT INTO turma (semestre_letivo, ano_letivo, sigla, tema_id) VALUES (?, ?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, turma.getSemestreLetivo());
			stmt.setInt(2, turma.getAnoLetivo());
			stmt.setObject(3, turma.getSigla());
			stmt.setObject(4, turma.getTurmaTema().getTema_id());
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

			String sql = "DELETE FROM turma WHERE id = ?";

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
	
	public ArrayList<Turma> getAllPeriodosLetivos() {
		String sql = "SELECT ano_letivo, semestre_letivo FROM turma order by ano_letivo desc;";
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
	
	public ArrayList<Turma> getAllTurmas() {
		String sql = "select tu.*, tu.id as turmaId, t.* from projeto.turma tu inner join projeto.tema t on tu.tema_id = t.id;";
		ArrayList<Turma> arrayAllTurmas = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Turma turma = new Turma();
					turma.setCodigoIdentificador(Integer.parseInt(rs.getString("turmaId")));
					turma.setSigla(rs.getString("sigla"));
					Tema tema = new Tema();
					tema.setTitulo(rs.getString("titulo"));
					turma.setTurmaTema(tema);
					turma.setSemestreLetivo(rs.getInt("semestre_letivo"));
					turma.setAnoLetivo(rs.getInt("ano_letivo"));
					arrayAllTurmas.add(turma);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayAllTurmas;
	}
	
	public ArrayList<Turma> getAnoLetivo() {
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
	
	public void vinculaAlunoTurma(int[] alunosIds, int turmaId) {
		
		conexao = new Conexao();

		try (Connection conn = Conexao.getConexaoMYSQL()) {

			String sql = "INSERT INTO turma_aluno (aluno_id, turma_id) VALUES (?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			for(int i = 0; i<= alunosIds.length - 1; i++) {
				stmt.setInt(1, alunosIds[i]);
				stmt.setInt(2, turmaId);
				stmt.execute();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	} 

}
