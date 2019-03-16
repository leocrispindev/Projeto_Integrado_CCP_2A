package br.com.usjt.projcontrol.model;

import java.util.Calendar;

public class Atividade {
	private int atividade_id;
	private int numero;
	private String descricao;
	private String formato;
	private Calendar data_inicio;
	private Calendar data_fim;
	
	public int getAtividade_id() {
		return atividade_id;
	}
	public void setAtividade_id(int atividade_id) {
		this.atividade_id = atividade_id;
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
	public Calendar getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Calendar data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Calendar getData_fim() {
		return data_fim;
	}
	public void setData_fim(Calendar data_fim) {
		this.data_fim = data_fim;
	}
	
	public Atividade() {}
	
}
