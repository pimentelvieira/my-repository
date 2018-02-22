package br.com.caelum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.caelum.model.Categoria;
import br.com.caelum.model.Loja;
import br.com.caelum.model.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;

	public List<Produto> getProdutos() {
		return em.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto getProduto(Integer id) {
		Produto produto = em.find(Produto.class, id);
		return produto;
	}

	public List<Produto> getProdutos(String nome, Integer categoriaId, Integer lojaId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);
		
		//O form traz todas as ocorrências, como se fosse o asterisco
		//O root traça uma rota para chegar aos atributos
		Root<Produto> root = query.from(Produto.class);
		
		//Essa rota ou caminho é chamada de Path, o método get também recebe um Generic de método do mesmo tipo do Path
		Path<String> nomePath = root.<String>get("nome");
		Path<Integer> categoriaPath = root.join("categorias").<Integer>get("id");
		Path<Integer> lojaPath = root.<Loja>get("loja").<Integer>get("id");
		
		List<Predicate> predicates = new ArrayList<>();
		
		//Aqui usamos o criteriaBuilder para fazer exatamente a mesma coisa que um like e um = do sql ou do jpql faria
		//Chamamos esses critérios como o like e o equal por exemplo de Predicates
		if(!nome.isEmpty()) {
			Predicate nomePredicate = criteriaBuilder.like(nomePath, nome);
			predicates.add(nomePredicate);
		}
		if(categoriaId != null) {
			Predicate categoriaPredicate = criteriaBuilder.equal(categoriaPath, categoriaId);
			predicates.add(categoriaPredicate);
		}
		if(lojaId != null) {
			Predicate lojaPredicate = criteriaBuilder.equal(lojaPath, lojaId);
			predicates.add(lojaPredicate);
		}
		
		//Adiciona os nosso predicates à query
		query.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Produto> typedQuery = em.createQuery(query);
		
		//Configuração de Hint (dica) para que essa query seja cacheável
		//Lembrando que para essa conf funcionar é necessário mexer nas configurações do hibernate
		typedQuery.setHint("org.hibernate.cacheable", "true");
		return typedQuery.getResultList();

	}

	public void insere(Produto produto) {
		if (produto.getId() == null)
			em.persist(produto);
		else
			em.merge(produto);
	}

}
