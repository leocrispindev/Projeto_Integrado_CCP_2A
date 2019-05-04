package br.com.usjt.projcontrol.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.usjt.projcontrol.Conexao.Conexao;
import br.com.usjt.projcontrol.model.Tema;

public class TemaDAO {
	
	public ArrayList<Tema> getTema() {
		String sql = "SELECT * FROM tema";
		ArrayList<Tema> arrayTema = new ArrayList<>();

		try (Connection conn = Conexao.getConexaoMYSQL()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {

					Tema tema = new Tema();
					tema.setTema_id(rs.getInt("tema_id"));
					tema.setTitulo(rs.getString("titulo"));
					
					arrayTema.add(tema);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayTema;
	}
}
