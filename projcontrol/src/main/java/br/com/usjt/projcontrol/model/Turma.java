package br.com.usjt.projcontrol.model;

import java.util.Date;

public class Turma {
	
	private String codigoIdentificador, sigla;
	private Date anoLetivo;
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
	public Date getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(Date anoLetivo) {
		this.anoLetivo = anoLetivo;
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
