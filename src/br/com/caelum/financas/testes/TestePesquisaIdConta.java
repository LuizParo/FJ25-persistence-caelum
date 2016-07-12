package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestePesquisaIdConta {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ContaDao dao = new ContaDao(em);
		
		Conta encontrado = dao.busca(2);
		
		System.out.println(encontrado.getTitular());
		em.close();
	}
}