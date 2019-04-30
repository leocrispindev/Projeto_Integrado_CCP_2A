package br.com.usjt.projcontrol.Service;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import br.com.usjt.projcontrol.Controller.Validacao;
import br.com.usjt.projcontrol.DAO.CredenciaisDAO;
import br.com.usjt.projcontrol.model.Aluno;

public class ServiceCredenciais extends Validacao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CredenciaisDAO credenciais = null;
	String[] mensagem = new String[3];
	
	public ServiceCredenciais() {
		credenciais = new CredenciaisDAO();
	}
	
	public String[] setUpdateCredenciais(String campo, String confirmCampo, int id, String tipoUpdate) {
		String sql = "";
		try {
			if(campo.equals(confirmCampo)) {
				
				if(tipoUpdate.equals("email")) {
					sql = "UPDATE usuario SET email = ? WHERE id = ?";
				}else {
					sql = "UPDATE usuario SET senha = ? WHERE id = ?";
				}
				
				credenciais.updateCredenciais(campo, id, sql);
				return this.getMensagemSucesso();
				
			}else {
				return this.getMensagemErro();
			}
			
		}catch(Exception e) {
			return this.getMensagemErro();
		}
	}
}
