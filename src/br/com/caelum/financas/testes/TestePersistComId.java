package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestePersistComId {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		manager.persist(conta); // org.hibernate.PersistentObjectException: detached entity passed to persist: br.com.caelum.financas.modelo.Conta
		manager.close();
		JPAUtil.closeEntityManagerFactory();
	}
}