package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Aluno;
import br.com.usjt.projcontrol.model.Atividade;
import br.com.usjt.projcontrol.model.Avaliacao;
import br.com.usjt.projcontrol.model.Grupo;
import br.com.usjt.projcontrol.model.Professor;
import br.com.usjt.projcontrol.model.Turma;

public class AvaliacaoDAO {

	private Conexao conexao = null;
	
	public ArrayList<Avaliacao> getAvaliacoes(String filtros) {
		
		ArrayList<Avaliacao> arrayAvaliacoes = new ArrayList<Avaliacao>();
		Avaliacao ava = null;
		conexao = new Conexao();
		Turma turmaA = null;
		Grupo grupoA = null;
		Professor professor = null;
	
		String sql ="SELECT " + 
				"  DISTINCT av.id AS avaliacao_id, " + 
				"  T.sigla AS sigla, " + 
				"  U.nome AS nome, " + 
				"  T.semestre_letivo AS semestre, " + 
				"  T.ano_letivo AS ano, " + 
				"  Av.nota AS nota, " + 
				"  G.nome AS nome_grupo, " + 
				"  G.id AS id_grupo " + 
				"FROM " + 
				"  turma T " + 
				"  INNER JOIN turma_aluno ta ON T.id = ta.turma_id " + 
				"  INNER JOIN grupo G ON Ta.grupo_id = G.id " + 
				"  INNER JOIN entrega e ON e.grupo_id = G.id " + 
				"  INNER JOIN avaliacao av ON av.entrega_id = e.id " + 
				"  INNER JOIN professor P ON P.professor_id = G.orientador_id " + 
				"  INNER JOIN usuario U ON P.professor_id = U.id " + filtros + ";" ;
		
		try (Connection conn = Conexao.getConexaoMYSQL()) {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				ava = new Avaliacao();
				ava.setAvaliacaoId(rs.getInt(1));
				ava.setNota(rs.getDouble("nota"));
				
				professor = new Professor();
				professor.setNome(rs.getString("nome"));
				
				grupoA = new Grupo();
				grupoA.setNome(rs.getNString("nome_grupo"));
				grupoA.setId(rs.getInt("id_grupo"));
				grupoA.setProfessor(professor);
				
				turmaA = new Turma();
				turmaA.setSigla(rs.getString("sigla"));
				turmaA.setSemestreLetivo(rs.getInt("semestre"));
				
				ava.setTurma(turmaA);
				ava.setGrupo(grupoA);
				
				arrayAvaliacoes.add(ava);
				
				
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.closeConexaoMYSQL();
		}
	
		return arrayAvaliacoes;
	}
	
//	public ArrayList<Avaliacao> getAvaliacoesByTurma(Turma turma) {
//		ArrayList<Avaliacao> arrayAvaliacoes = new ArrayList<Avaliacao>();
//		String sql = "SELECT " + 
//				"t.ano_letivo, t.semestre_letivo, t.sigla, u.nome, g.numero " + 
//				"FROM avaliacao a " + 
//				"INNER JOIN turma_aluno ta ON a.turma_aluno_id = ta.turma_id " + 
//				"INNER JOIN turma t ON ta.turma_id = t.id " + 
//				"INNER JOIN grupo g ON ta.grupo_id = g.id " + 
//				"INNER JOIN professor p ON g.orientador_id = p.professor_id " + 
//				"INNER JOIN usuario u ON p.professor_id = u.id " + 
//				"WHERE t.semestre_letivo = ? AND t.ano_letivo = ?;";
//		
//		try (Connection conn = Conexao.getConexaoMYSQL()) {
//			
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			
//			while (rs.next()) {
//
//				arrayAvaliacoes.add(ava);	
//			}
//	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			conexao.closeConexaoMYSQL();
//		}
//	
//		return arrayAvaliacoes;
//	}
	
	public ArrayList<Avaliacao> getAvaliacoesByDate() {
		ArrayList<Avaliacao> arrayAvaliacoes = new ArrayList<Avaliacao>();
		String sql = "SELECT DISTINCT\r\n" + 
				"t.ano_letivo, t.semestre_letivo \r\n" + 
				"FROM avaliacao a\r\n" + 
				"INNER JOIN turma_aluno ta ON a.turma_aluno_id = ta.turma_id\r\n" + 
				"INNER JOIN turma t ON ta.turma_id = t.id;";

		try (Connection conn = Conexao.getConexaoMYSQL()) {

			PreparedStatement stmt = conn.prepareStatement(sql);
			try(ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Avaliacao ava = new Avaliacao();
					Turma t = new Turma();
					t.setAnoLetivo(rs.getInt("ano_letivo"));
					t.setSemestreLetivo(rs.getInt("semestre_letivo"));
					ava.setTurma(t);
					arrayAvaliacoes.add(ava);	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public ArrayList<Avaliacao> getAvaliacaoDetalhes(int avaliacaoId) {
		ArrayList<Avaliacao> arrayAvaliacoes = new ArrayList<Avaliacao>();
			String sql = "SELECT " + 
					"  u.nome, " + 
					"  a.ra, " + 
					"  t.id 'turma_id', " + 
					"  t.sigla, " + 
					"  g.id 'grupo_id', " + 
					"  g.numero 'grupo_numero', " + 
					"  g.nome 'grupo_nome', " + 
					"  ati.numero 'atividade_num', " + 
					"  ati.descricao, " + 
					"  av.nota, " + 
					"  av.comentarios, " + 
					"  av.dt_avaliacao " + 
					"FROM " + 
					"  usuario u " + 
					"  INNER JOIN aluno a ON a.aluno_id = u.id " + 
					"  INNER JOIN turma_aluno ta ON a.aluno_id = ta.aluno_id " + 
					"  INNER JOIN turma t ON t.id = ta.turma_id " + 
					"  INNER JOIN grupo g ON g.id = ta.grupo_id " + 
					"  INNER JOIN entrega e ON e.grupo_id = g.id " + 
					"  INNER JOIN atividade ati ON ati.id = e.atividade_id " + 
					"  INNER JOIN avaliacao av ON av.entrega_id = e.id " + 
					"  WHERE av.id = ?;";
		try (Connection conn = Conexao.getConexaoMYSQL()) {

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, avaliacaoId);
			try(ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Aluno aluno = new Aluno();
					aluno.setNome(rs.getString("nome"));
					aluno.setRa(rs.getInt("ra"));
					
					Atividade atividade = new Atividade();
					atividade.setDescricao(rs.getString("descricao"));
					atividade.setNumero(rs.getInt("atividade_num"));
					
					Avaliacao avaliacao = new Avaliacao();
					avaliacao.setNota(rs.getInt("nota"));
					avaliacao.setComentario(rs.getString("comentarios"));
					avaliacao.setDataAvaliacao(rs.getDate("dt_avaliacao"));
					avaliacao.setAtividade(atividade);
					
					Turma turma = new Turma();
					turma.setCodigoIdentificador(rs.getInt("turma_id"));
					turma.setSigla(rs.getString("sigla"));
					turma.setAlunos(aluno);
					
					Grupo grupo = new Grupo();
					grupo.setId(rs.getInt("grupo_id"));
					grupo.setNome(rs.getString("grupo_nome"));
					grupo.setNumero_grupo(rs.getInt("grupo_numero"));
					
					avaliacao.setTurma(turma);
					avaliacao.setGrupo(grupo);
					arrayAvaliacoes.add(avaliacao);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return arrayAvaliacoes;
	}
}