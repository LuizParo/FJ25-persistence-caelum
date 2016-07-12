package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteRollbackEmFlush {
	public static void main(String[] args) throws InterruptedException {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();

		Conta conta = manager.find(Conta.class, 3);
		conta.setTitular("Chico");
		
		manager.flush();
		
		Thread.sleep(5000);
		
		manager.getTransaction().rollback();
	}
}