package br.com.usjt.projcontrol.Service;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.usjt.projcontrol.DAO.ProfessorDAO;
import br.com.usjt.projcontrol.model.Professor;

public class ServiceProfessor implements Serializable {
	
	private static final long serialVersionUID = -7984208492786047807L;
	
	private ProfessorDAO professorDAO;
	private String mensagem = "";

	public ServiceProfessor() {
		professorDAO = new ProfessorDAO();
	}

	public Professor setCredencaisLogin(Professor professor) {
		return professorDAO.loginProfessor(professor);
	}
	

	/*public String setUpdate(Professor professor) {
		try {

			professorDAO.updateProfessor(professor);
			mensagem = "OperaÃ§Ã£o Efetuada com Sucesso";

		} catch (Exception e) {
			mensagem = "Houve um erro no processo. Contate o Administrador do sistema.";
		}

		return mensagem;
	}*/

	public String setDelete(int id) {
		try {

			professorDAO.deleteProfessor(id);
			mensagem = "OperaÃ§Ã£o Efetuada com Sucesso";

		} catch (Exception e) {
			mensagem = "Houve um erro no processo. Contate o Administrador do sistema.";
		}

		return mensagem;
	}
	
	public ArrayList<Professor> getListaProfessores() {
		ArrayList<Professor> professores = professorDAO.getProfessores();
		return professores;
	}
	
	public ArrayList<Professor> getListaProfessoresByPeriodo(int ano, int semestre){
		ArrayList<Professor> professores = professorDAO.getProfessoresByPeriodo(ano, semestre);
		return professores;
	}

}