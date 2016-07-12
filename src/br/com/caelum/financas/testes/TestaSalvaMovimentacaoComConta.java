package br.com.caelum.financas.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setBanco("99999-9");
		conta.setAgencia("999");
		conta.setTitular("Maria");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("conta de luz - abril/2010");
		movimentacao.setValor(new BigDecimal("100"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		manager.persist(conta);
		dao.adiciona(movimentacao);
		
		manager.getTransaction().commit(); // org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : br.com.caelum.financas.modelo.Movimentacao.conta -> br.com.caelum.financas.modelo.Conta
		manager.close();
	}
}