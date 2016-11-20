package br.com.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.beans.Funcionario;

@Stateless
@Local(FuncionarioIT.class)
public class FuncionarioDAO implements FuncionarioIT {

	@PersistenceContext(unitName="jdbc/funcionario")
	EntityManager em;
	
	@Override
	public void addFuncionario(Funcionario funcionario) {
		
		em.persist(funcionario);
		
	}

}
