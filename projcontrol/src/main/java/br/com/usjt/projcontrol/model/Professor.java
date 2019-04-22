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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (adm != other.adm)
			return false;
		if (matricula != other.matricula)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Professor [Matricula:" + matricula + ", adm:" + adm + ", Id:" + getId() + ", Nome:"
				+ getNome() + ", Email:" + getEmail() + ", Senha:" + getSenha() + "]";
	}
}
