package br.com.usjt.projcontrol.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Banca {
	private Grupo grupo;
	private Calendar data;
	private String sala;
	private ArrayList<ProfessorBanca> professores;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public ArrayList<ProfessorBanca> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<ProfessorBanca> professores) {
		this.professores = professores;
	}
	
	public Banca() {}
	
	
	
	
	
	
	
	

}