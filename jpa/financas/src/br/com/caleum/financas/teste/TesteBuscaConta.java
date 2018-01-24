package br.com.caleum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		System.out.println(conta.getTitular());
		
		//Se a instrução abaixo rodar, acontece um update, pois o estado é managed, automaticamente a JPA sabe que precisa ser feito um update
		//**Se não tiver alteração nenhuma com relação ao que já existe no banco, nada é feito.
		//conta.setTitular("Joao");
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("William");
	}
}
