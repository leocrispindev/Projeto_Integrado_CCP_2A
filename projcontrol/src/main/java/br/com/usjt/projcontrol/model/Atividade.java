package br.com.usjt.projcontrol.model;

import java.util.Calendar;

public class Atividade {
	private int atividadeId;
	private int numero;
	private String descricao;
	private String formato;
	private Calendar dataInicio;
	private Calendar dataFim;
	
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
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDataFim() {
		return dataFim;
	}
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	
	public Atividade() {}
	
}
