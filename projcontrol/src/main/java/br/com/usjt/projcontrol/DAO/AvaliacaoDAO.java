package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Avaliacao;

public class AvaliacaoDAO {
	
	public ArrayList<Avaliacao> getAvaliacoes() {		
		String sql = "SELECT a.* FROM avaliacao a "
				+ "INNER JOIN turma_aluno ta ON a.id = ta.id "
				+ "INNER JOIN entrega e ON e.id = a.id;";
		
		ArrayList<Avaliacao> arrayAvaliacoes = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			try(ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Avaliacao ava = new Avaliacao();
					ava.setAvaliacaoId(rs.getInt(1));
					ava.setComentario(rs.getString("comentarios"));
					ava.setDataAvaliacao(rs.getDate("dt_avaliacao"));
					ava.setNota(rs.getDouble("nota"));
					arrayAvaliacoes.add(ava);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return arrayAvaliacoes;
	}
	
	public int getAvaliacaoId() {

		String sqlAvaliacaoId = "SELECT id FROM avaliacao ORDER BY id DESC LIMIT 0,1";
		int avaliacaoId = 0;

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sqlAvaliacaoId);
			try (ResultSet rs = stmt.executeQuery();) {
				while(rs.next())
					avaliacaoId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avaliacaoId;
	}
}