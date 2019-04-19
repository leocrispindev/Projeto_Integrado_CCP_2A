package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Avaliacao;

public class AvaliacaoDAO {

	private Conexao conexao = null;
	
	public ArrayList<Avaliacao> getAvaliacoes() {
		String sql = "SELECT a.* FROM avaliacao a INNER JOIN turma_aluno ta ON a.id = ta.id INNER JOIN entrega e ON e.id = a.id;";
		ArrayList<Avaliacao> arrayAvaliacoes = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Avaliacao ava = new Avaliacao();
				ava.setAvaliacaoId(rs.getInt(1));
				ava.setComentario(rs.getString("comentarios"));
				ava.setDataAvaliacao(rs.getDate("dt_avaliacao"));
				ava.setNota(rs.getDouble("nota"));
				arrayAvaliacoes.add(ava);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.closeConexaoMYSQL();
		}
		return arrayAvaliacoes;
	}
	
	
	public void getAvaliacaoId() {

		String sqlAvaliacaoId = "SELECT id FROM grupo ORDER BY id DESC LIMIT 0,1";

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlAvaliacaoId);

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conexao.closeConexaoMYSQL();
		}
	}
}