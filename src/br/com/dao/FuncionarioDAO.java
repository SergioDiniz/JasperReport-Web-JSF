package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.beans.Funcionario;

public class FuncionarioDAO {

	EntityManager em;
	
	public FuncionarioDAO(){
		em = Persistence.createEntityManagerFactory("funcionarioPU").createEntityManager();
	}
	
	public void addFuncionario(Funcionario funcionario){
		try {
			em.getTransaction().begin();
			em.persist(funcionario);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
}
