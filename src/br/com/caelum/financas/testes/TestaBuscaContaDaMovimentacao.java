package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaDaMovimentacao {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		
		Movimentacao movimentacao = dao.busca(2);
		System.out.println(movimentacao.getConta().getTitular());
	}
}