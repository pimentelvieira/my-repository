package br.com.caleum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteRemoveConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		//Para executar a remoção a JPA exige que o estado do objeto a ser removido seja managed
		//Para isso fazemos uma busca abaixo
		Conta conta = em.find(Conta.class, 1);
		
		em.getTransaction().begin();
		
		//Estado managed --> remove() --> Estado removed
		em.remove(conta);
		
		em.getTransaction().commit();
		
		//Detalhe
		//Caso criarmos um objeto e setarmos o Id dele com um que existe na base, conforme abaixo
		//O estado dele será detached. A JPA considera isso ao fazer um remove por exemplo
		Conta conta2 = new Conta();
		conta2.setId(1);
		em.getTransaction().begin();
		em.remove(conta2);
		em.getTransaction().commit();
	}
}
