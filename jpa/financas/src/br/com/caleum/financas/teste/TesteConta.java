package br.com.caleum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		//Criação da Conta
		Conta conta = new Conta();
		conta.setTitular("Danilo");
		conta.setAgencia("123");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("456");
		
		//Aqui o estado do objeto conta é Transient, onde o objeto acabou de ser criado e ainda não é gerenciado pelo banco.
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		//Inicia transação, persiste conta e commita transação.
		em.getTransaction().begin();
		
		//No método persist a conta passa a ser Managed, o persist além de incluir no banco, também passa o objeto do
		//estado Transient para o estado Managed
		//Estado transient --> persist() --> Estado managed
		em.persist(conta);
		
		//Se a linha abaixo rodar, acontecerá um update, já que o estado do objeto é Managed
		//conta.setBanco("Bradesco");
		
		em.getTransaction().commit();
		
		//Fecha objetos que controlam as entidades --> Boa prática <--
		em.close();
	}
}
