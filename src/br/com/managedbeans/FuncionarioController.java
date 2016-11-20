package br.com.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.beans.Funcionario;
import br.com.sessionbeans.FuncionarioIT;

@ManagedBean
public class FuncionarioController {

	private Funcionario funcionario;
	
	@EJB
	private FuncionarioIT dao;
	
	public FuncionarioController() {
		this.funcionario = new Funcionario();
	}
	
	
	
	public void addFuncionario(){
		dao.addFuncionario(this.funcionario);
	}
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
}
