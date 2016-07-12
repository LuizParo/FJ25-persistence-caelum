package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteQtdSelectNoPersist {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Chico");
		manager.getTransaction().begin();
		manager.persist(conta);
		System.out.println(conta.getId());
		conta.setTitular("Chico");
		manager.getTransaction().commit();
	}
}