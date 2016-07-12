package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteAlteraConta {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ContaDao dao = new ContaDao(em);
		
		em.getTransaction().begin();
		
		Conta conta = dao.busca(2);
		conta.setTitular("Joãozinho");
		
		em.getTransaction().commit();
		em.close();
	}
}