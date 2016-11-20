package br.com.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.beans.Funcionario;
import br.com.sessionbeans.FuncionarioIT;

@ManagedBean
@ViewScoped
public class FuncionarioController implements Serializable {

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	
	@EJB
	private FuncionarioIT dao;
	
	public FuncionarioController() {
	}
	
	@PostConstruct
	public void init(){
		this.funcionario = new Funcionario();
		this.funcionarios = dao.listFuncionarios();
	}
	
	
	
	public void addFuncionario(){
		dao.addFuncionario(this.funcionario);
		funcionario = new Funcionario();
		this.funcionarios = dao.listFuncionarios();
	}
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}



	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
	
	
	
}
