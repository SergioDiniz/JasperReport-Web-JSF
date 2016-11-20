package br.com.interfaces;

import java.util.List;

import br.com.beans.Funcionario;

public interface FuncionarioDAOIT {

	void addFuncionario(Funcionario funcionario);
	
	List<Funcionario> listFuncionarios();
	
}
