package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMergeSemId {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		Conta c = new Conta();
		c.setId(7);
		
		manager.getTransaction().begin();
		manager.merge(c); // Nenhum erro acontece
		manager.getTransaction().commit();
		manager.close();
	}
}