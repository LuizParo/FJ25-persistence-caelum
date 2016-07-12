package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDao {
	private EntityManager em;

	public ContaDao(EntityManager em) {
		this.em = em;
	}
	
	public Conta busca(Integer id) {
		return this.em.find(Conta.class, id);
	}
	
	public void adiciona(Conta c) {
		this.em.persist(c);
	}
	
	public void remove(Conta c) {
		this.em.remove(c);
	}
	
	public List<Conta> lista() {
		return this.em.createQuery("select c from Conta c", Conta.class).getResultList();
	}
}