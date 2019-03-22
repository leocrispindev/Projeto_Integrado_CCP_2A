package br.com.usjt.projcontrol.model;

public class Grupo {
	private Professor professor;
	private int numero_grupo;
	private String nome;
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getNumero_grupo() {
		return numero_grupo;
	}

	public void setNumero_grupo(int numero_grupo) {
		this.numero_grupo = numero_grupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Grupo() {}
}
