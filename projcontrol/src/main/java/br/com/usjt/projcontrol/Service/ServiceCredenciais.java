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
	
	public String[] setUpdateEmail(String email, String confirmEmail, int id) {
		try {
			if(email.equals(confirmEmail)) {
				
				credenciais.updateEmail(email, id);
				return this.getMensagemSucesso();
				
			}else {
				return this.getMensagemErro();
			}
			
		}catch(Exception e) {
			return this.getMensagemErro();
		}
	}
}
