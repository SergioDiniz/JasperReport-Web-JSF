package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	public List<Funcionario> listFuncionarios(){
		List<Funcionario> funcionarios = new ArrayList<>();
		
		try {
			
			Query query = em.createQuery("from Funcionario");
			funcionarios = query.getResultList();
			
		} finally {
			em.close();
		}
		
		return funcionarios;
	}
	
}
