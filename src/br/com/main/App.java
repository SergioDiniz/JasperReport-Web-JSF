package br.com.main;

import br.com.beans.Funcionario;
import br.com.dao.FuncionarioDAO;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Funcionario f = new Funcionario();
		f.setEmail("email");
		f.setNome("nome");
		f.setEndereco("endereco");
		
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.addFuncionario(f);
		
		System.out.println("OK!");
	}

}
