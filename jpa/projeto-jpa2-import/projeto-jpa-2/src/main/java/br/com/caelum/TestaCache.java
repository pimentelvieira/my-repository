package br.com.caelum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.model.Produto;

//O cache padr�o do Hibernate � o de primeiro n�vel, onde os acessos s�o gerenciados a partir do entity manager
//ou seja, se fizermos dois finds para o mesmo id com o mesmo entity manager, s� sera feito um na verdade
//J� se fizermos dois finds utilizando dois entity managers diferentes o cache n�o funcionar� por padr�o

//J� com o cache de segundo n�vel, ir� existir uma �rea compartilhada por todos os Entity Managers, ou seja,
//Se um entity manager j� fez uma consulta para um determinado id por exemplo, o outro saber� e utilizar� o cache
//de segundo n�vel para obter a informa��o.
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
