package br.com.caleum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		//JPQL para buscar com base em um objeto Conta
		String jpql = "select m from Movimentacao m where m.conta = :pConta";
		
		//JPQL para buscar com base em um objeto Conta e ordernar com base no valor decrescentemente
		String jpql2 = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
		
		//JPQL para buscar com base em um objeto Conta e no tipo ordernar com base no valor decrescentemente
		String jpql3 = "select m from Movimentacao m where m.conta = :pConta"
				+ " and m.tipo = :pTipo"
				+ " order by m.valor desc";
				
		Query query = em.createQuery(jpql3);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		List<Movimentacao> resultado = query.getResultList();
		
		for (Movimentacao movimentacao : resultado) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta Id: " + movimentacao.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
