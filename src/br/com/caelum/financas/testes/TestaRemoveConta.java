package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRemoveConta {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ContaDao dao = new ContaDao(em);
		
		em.getTransaction().begin();
		
		Conta conta = dao.busca(6);
		dao.remove(conta);
		
		em.getTransaction().commit();
		
		em.close();
	}
}