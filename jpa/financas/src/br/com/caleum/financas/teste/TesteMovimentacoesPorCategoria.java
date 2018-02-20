package br.com.caleum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		//JPQL para buscar com base em um objeto Categoria
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
				
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		List<Movimentacao> resultado = query.getResultList();
		
		for (Movimentacao movimentacao : resultado) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta Id: " + movimentacao.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
