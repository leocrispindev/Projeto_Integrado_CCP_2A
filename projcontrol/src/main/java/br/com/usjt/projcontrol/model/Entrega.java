package br.com.usjt.projcontrol.model;
import java.util.Calendar;

public class Entrega {
	
	private int entregaId;
	private int grupoId;
	private int atividadeIda;
	private Calendar dataCadastro;
	
	
	public int getEntregaId() {
		return entregaId;
	}
	public void setEntregaId(int entregaId) {
		this.entregaId = entregaId;
	}
	public int getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}
	public int getAtividadeIda() {
		return atividadeIda;
	}
	public void setAtividadeIda(int atividadeIda) {
		this.atividadeIda = atividadeIda;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Entrega() {}
	
}
