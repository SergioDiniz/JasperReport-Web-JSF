package br.com.sessionbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.beans.Funcionario;

@Stateless
@Local(FuncionarioIT.class)
public class FuncionarioDAO implements FuncionarioIT {

	@PersistenceContext(unitName="jdbc/funcionario")
	EntityManager em;
	
	@Override
	public void addFuncionario(Funcionario funcionario) {
		
		funcionario.setNascimento(new Date());
		em.persist(funcionario);
		
	}

	@Override
	public List<Funcionario> listFuncionarios() {
		
		Query query = em.createQuery("select f from Funcionario f");
		List<Funcionario> fs = query.getResultList();
		
		if(fs.size() > 0){
			return fs;
		}
		
		return null;
		
	}

}
