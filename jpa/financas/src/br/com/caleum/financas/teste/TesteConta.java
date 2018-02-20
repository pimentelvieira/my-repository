package br.com.caleum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		//Cria��o da Conta
		Conta conta = new Conta();
		conta.setTitular("Danilo");
		conta.setAgencia("123");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("456");
		
		//Aqui o estado do objeto conta � Transient, onde o objeto acabou de ser criado e ainda n�o � gerenciado pelo banco.
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		//Inicia transa��o, persiste conta e commita transa��o.
		em.getTransaction().begin();
		
		//No m�todo persist a conta passa a ser Managed, o persist al�m de incluir no banco, tamb�m passa o objeto do
		//estado Transient para o estado Managed
		//Estado transient --> persist() --> Estado managed
		em.persist(conta);
		
		//Se a linha abaixo rodar, acontecer� um update, j� que o estado do objeto � Managed
		//conta.setBanco("Bradesco");
		
		em.getTransaction().commit();
		
		//Fecha objetos que controlam as entidades --> Boa pr�tica <--
		em.close();
	}
}
