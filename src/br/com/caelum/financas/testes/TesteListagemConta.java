package br.com.caelum.financas.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteListagemConta {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ContaDao dao = new ContaDao(em);
		
		List<Conta> lista = dao.lista();
		
		for (Conta conta : lista) {
			System.out.println(conta.getNumero());
		}
		
		em.close();
	}
}