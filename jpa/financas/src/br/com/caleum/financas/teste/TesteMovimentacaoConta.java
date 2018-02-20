package br.com.caleum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao mov = em.find(Movimentacao.class, 1);
		Conta conta = mov.getConta();
		
		System.out.println(conta.getTitular());
		System.out.println(conta.getMovimentacoes().size());
		
		em.getTransaction().commit();
		em.close();
		System.exit(0);
	}
}
