package br.com.sessionbeans;

import java.util.List;

import br.com.beans.Funcionario;

public interface FuncionarioIT {

	void addFuncionario(Funcionario funcionario);
	
	List<Funcionario> listFuncionarios();
	
}
