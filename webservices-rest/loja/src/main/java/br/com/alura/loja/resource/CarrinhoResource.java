package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

//Classe que representa o recurso que irá produzir a informação a ser
//consumida pelo cliente.
@Path("carrinhos") //Essa anotação serve para configurarmos o caminho onde o recurso será chamado
public class CarrinhoResource {

//	@Path("{id}")//Informa que após a URI padrão (/carrinhos) virá o id
//	@GET //Informa que o recurso será chamado via método Get do Http
//	@Produces(MediaType.APPLICATION_XML) //Informa que o resultado será um XML
//	public String busca(@PathParam("id") long id) { //Para pegar o id que vem da url depois de /carrinhos
//		Carrinho carrinho = new CarrinhoDAO().busca(id);
//		return carrinho.toXML();
//	}
	
	//Implementação com JAX-B
	@Path("{id}")//Informa que após a URI padrão (/carrinhos) virá o id
	@GET //Informa que o recurso será chamado via método Get do Http
	@Produces(MediaType.APPLICATION_XML) //Informa que o resultado será um XML
	public Carrinho busca(@PathParam("id") long id) { //Para pegar o id que vem da url depois de /carrinhos
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		return carrinho;
	}
	
	@POST //Usado para enviar dados, no nosso caso, dados XML
	@Consumes(MediaType.APPLICATION_XML) //Indica que esse método consome xml
	public Response adiciona(Carrinho carrinho) {
		new CarrinhoDAO().adiciona(carrinho);
		URI uri = URI.create("/carrinhos/" + carrinho.getId()); //Cria a URL que será retornada como resposta, fazemos isso pois esse método cria um carrinho
		return Response.created(uri).build(); //Retorna a URL com o código Http 201
	}
	
	@Path("{id}/produtos/{produtoId}")
	@DELETE
	public Response removeProduto(@PathParam("id") long id, @PathParam("produtoId") long produtoId) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		carrinho.remove(produtoId);
		return Response.ok().build();
	}
	
	@Path("{id}/produtos/{produtoId}")
	@PUT
	public Response alteraProduto(String conteudo, @PathParam("id") long id, @PathParam("produtoId") long produtoId) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(conteudo);
		carrinho.troca(produto);
		return Response.ok().build();
	}
	
	@Path("{id}/produtos/{produtoId}/quantidade")
	@PUT
	public Response alteraQuantidade(String conteudo, @PathParam("id") long id, @PathParam("produtoId") long produtoId) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(conteudo);
		carrinho.trocaQuantidade(produto);
		return Response.ok().build();
	}
	
//	@Path("{id}")//Informa que após a URI padrão (/carrinhos) virá o id
//	@GET //Informa que o recurso será chamado via método Get do Http
//	@Produces(MediaType.APPLICATION_JSON) //Informa que o resultado será um Json
//	public String busca(@PathParam("id") long id) { //Para pegar o id que vem da url depois de /carrinhos
//		Carrinho carrinho = new CarrinhoDAO().busca(id);
//		return carrinho.toJson();
//	}
}
