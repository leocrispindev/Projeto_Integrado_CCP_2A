package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Atividade;
import br.com.usjt.projcontrol.model.Tema;

public class AtividadeDAO {

	Conexao conexao = null;
	String mensagem = "";
	
	public ArrayList<Atividade> getAtividades() {
		String sql = "SELECT a.*, t.dt_cadastro, t.titulo, t.introducao, t.requisitos FROM atividade a INNER JOIN tema t ON a.id = t.id;";
		ArrayList<Atividade> arrayAtividades = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Atividade atividade = new Atividade();
				atividade.setAtividadeId(rs.getInt("id"));
				atividade.setNumero(rs.getInt("numero"));
				atividade.setDescricao(rs.getString("descricao"));
				atividade.setFormato(rs.getString("formato_entrega"));
				atividade.setDataInicio(rs.getDate("dt_inicio"));
				atividade.setDataFim(rs.getDate("dt_fim"));
				Tema tema = new Tema();
				tema.setTema_id(rs.getInt("tema_id"));
				tema.setTitulo(rs.getString("titulo"));
				tema.setIntroducao(rs.getString("introducao"));
				tema.setRequisitos(rs.getString("requisitos"));
				atividade.setTema(tema);
				arrayAtividades.add(atividade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.closeConexaoMYSQL();
		}
		return arrayAtividades;
	}

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
