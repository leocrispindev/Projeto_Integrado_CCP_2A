package br.com.usjt.projcontrol.model;

public class Professor extends Usuario{
	private int matricula;
	private boolean adm;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public boolean isAdm() {
		return adm;
	}
	public void setAdm(boolean adm) {
		this.adm = adm;
	}
	
	public Professor() {}
}
