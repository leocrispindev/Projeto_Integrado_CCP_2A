package br.com.usjt.projcontrol.model;

import java.sql.Date;
import java.util.Calendar;

public class Atividade {
	private int atividadeId;
	private int numero;
	private String descricao;
	private String formato;
	private Date dataInicio;
	private Date dataFim;
	private Tema tema;
	
	public int getAtividadeId() {
		return atividadeId;
	}
	public void setAtividadeId(int atividadeId) {
		this.atividadeId = atividadeId;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public Atividade() {}
	
}
