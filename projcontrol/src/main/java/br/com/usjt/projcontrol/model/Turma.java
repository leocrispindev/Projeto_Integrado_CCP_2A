package br.com.usjt.projcontrol.model;

import java.util.Date;

public class Turma {
	
	private String codigoIdentificador;
	private Date anoLetivo;
	private Aluno alunos;
	
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
	
	public Turma() {}
}
