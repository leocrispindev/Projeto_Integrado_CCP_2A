package br.com.usjt.projcontrol.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Avaliacao {
	private int avaliacaoId;
	private double nota;
	private String comentario;
	private Calendar dataAvaliacao;
	private ArrayList<Entrega> entregas;
	
	public int getAvaliacaoId() {
		return avaliacaoId;
	}

	public void setAvaliacaoId(int avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
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

	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public ArrayList<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(ArrayList<Entrega> entregas) {
		this.entregas = entregas;
	}

	public Avaliacao() {}
	
	
}
