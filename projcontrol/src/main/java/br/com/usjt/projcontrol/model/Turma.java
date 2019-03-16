package br.com.usjt.projcontrol.model;

import java.util.Calendar;

public class Turma {
	
	private String codigoIdentificador;
	private Calendar anoLetivo;
	private Aluno alunos;
	
	public String getCodigoIdentificador() {
		return codigoIdentificador;
	}
	public void setCodigoIdentificador(String codigoIdentificador) {
		this.codigoIdentificador = codigoIdentificador;
	}
	public Calendar getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(Calendar anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public Aluno getAlunos() {
		return alunos;
	}
	public void setAlunos(Aluno alunos) {
		this.alunos = alunos;
	}
	
	public Turma() {}
}
