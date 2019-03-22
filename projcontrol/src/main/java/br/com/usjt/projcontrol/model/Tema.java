package br.com.usjt.projcontrol.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Tema {
	private int tema_id;
	private Calendar data_cadastro;
	private String titulo;
	private String introducao;
	private String requisitos;
	private ArrayList<Turma> turmas;
	private ArrayList<Atividade> atividades;
	
	public int getTema_id() {
		return tema_id;
	}

	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}

	public Calendar getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Calendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}

	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(ArrayList<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Tema() {}
}
