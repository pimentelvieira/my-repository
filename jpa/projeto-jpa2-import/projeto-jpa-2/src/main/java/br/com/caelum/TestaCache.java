package br.com.caelum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.model.Produto;

//O cache padrão do Hibernate é o de primeiro nível, onde os acessos são gerenciados a partir do entity manager
//ou seja, se fizermos dois finds para o mesmo id com o mesmo entity manager, só sera feito um na verdade
//Já se fizermos dois finds utilizando dois entity managers diferentes o cache não funcionará por padrão

//Já com o cache de segundo nível, irá existir uma área compartilhada por todos os Entity Managers, ou seja,
//Se um entity manager já fez uma consulta para um determinado id por exemplo, o outro saberá e utilizará o cache
//de segundo nível para obter a informação.
public class TestaCache {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);
		EntityManagerFactory entityManagerFactory = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityManager em2 = entityManagerFactory.createEntityManager();
		
		Produto produto = em.find(Produto.class, 1);
		Produto produto2 = em2.find(Produto.class, 1);
		System.out.println(produto.getNome());
		System.out.println(produto2.getNome());
		
		em.close();
	}
}
