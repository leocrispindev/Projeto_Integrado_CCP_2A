package br.com.usjt.projcontrol.model;

import java.sql.Date;
import java.util.ArrayList;

public class Avaliacao {
	private int avaliacaoId;
	private double nota;
	private String comentario;
	private Date dataAvaliacao;
	private ArrayList<Entrega> entregas;
	private Turma turma;
	private Grupo grupo;
	
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

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public ArrayList<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(ArrayList<Entrega> entregas) {
		this.entregas = entregas;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Avaliacao() {}
	
	
}
