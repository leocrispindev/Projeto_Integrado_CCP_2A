package br.com.usjt.projcontrol.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Avaliacao {
	private int avaliacao_id;
	private double nota;
	private String comentario;
	private Calendar data_avaliacao;
	private ArrayList<Entrega> entregas;
	
	public int getAvaliacao_id() {
		return avaliacao_id;
	}

	public void setAvaliacao_id(int avaliacao_id) {
		this.avaliacao_id = avaliacao_id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Calendar getData_avaliacao() {
		return data_avaliacao;
	}

	public void setData_avaliacao(Calendar data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}

	public ArrayList<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(ArrayList<Entrega> entregas) {
		this.entregas = entregas;
	}

	public Avaliacao() {}
	
	
}
