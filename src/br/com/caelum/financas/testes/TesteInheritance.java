package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Pessoa;
import br.com.caelum.financas.modelo.PessoaFisica;
import br.com.caelum.financas.modelo.PessoaJuridica;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInheritance {
	public static void main(String[] args) {
		Pessoa pessoaJuridica = new PessoaJuridica();
		Pessoa pessoaFisica = new PessoaFisica();
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(pessoaFisica);
		manager.persist(pessoaJuridica);
		
		manager.getTransaction().commit();
		manager.close();
		JPAUtil.closeEntityManagerFactory();
	}
}