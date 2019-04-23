package br.com.usjt.projcontrol.model;


public class Turma {
	
	private String codigoIdentificador, sigla;
	private int anoLetivo;
	private int semestreLetivo;
	private Aluno alunos;
	private Tema turmaTema;
	
	public Tema getTurmaTema() {
		return turmaTema;
	}
	public void setTurmaTema(Tema turmaTema) {
		this.turmaTema = turmaTema;
	}
	public String getCodigoIdentificador() {
		return codigoIdentificador;
	}
	public void setCodigoIdentificador(String codigoIdentificador) {
		this.codigoIdentificador = codigoIdentificador;
	}
	public int getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public int getSemestreLetivo() {
		return semestreLetivo;
	}
	public void setSemestreLetivo(int semestreLetivo) {
		this.semestreLetivo = semestreLetivo;
	}
	public Aluno getAlunos() {
		return alunos;
	}
	public void setAlunos(Aluno alunos) {
		this.alunos = alunos;
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public Turma() {}
}
