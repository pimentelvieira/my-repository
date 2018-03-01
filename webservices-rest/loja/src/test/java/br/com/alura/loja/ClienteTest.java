package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

//Classe de Teste para nossa requisição para nosso serviço de carrinho
public class ClienteTest {
	
	private HttpServer server;
	private WebTarget target;
	private Client client;

	@Before
	public void before() {
		this.server = Servidor.inicializa();
		//ClientConfig para registrar um Logger
		ClientConfig config = new ClientConfig();
		//Registra o Logger
		config.register(new LoggingFilter());
		//Cria o client
		this.client = ClientBuilder.newClient(config);
		//Configura o target, ou seja, onde a nossa request irá bater
		target = client.target("http://localhost:8080");
	}
	
	@After
	public void after() {
		//Mata o servidor http
		this.server.stop();
	}
	
	@Test //Testando Get
	public void testaQueAConexaoComOServidorFunciona() {
		
		//Pega o conteúdo de retorno para um path específico que vem o localhost
		String conteudo = target.path("carrinhos/1").request().get(String.class);
		
		//Utilizando JAXB
		Carrinho carrinho = target.path("carrinhos/1").request().get(Carrinho.class);
		
		//Testa para verificar se o retorno está correto
		Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}
	
	@Test //Testando Post
	public void testaEnvioDadosViaPost() {
		//Cria o client
		Client client = ClientBuilder.newClient();
		
		//Configura o target, ou seja, onde a nossa request irá bater
		WebTarget target = client.target("http://localhost:8080");
		
		//Cria um novo carrinho e o transforma em XML
		Carrinho carrinho = new Carrinho();
		carrinho.adiciona(new Produto(314L, "Tablet", 999, 1));
		carrinho.setRua("Rua Vergueiro");
		carrinho.setCidade("Sao Paulo");
		String xml = carrinho.toXML();
		
		Entity<Carrinho> entity = Entity.entity(carrinho, MediaType.APPLICATION_XML);
		
		Response response = target.path("/carrinhos").request().post(entity);
		
		Assert.assertEquals(201, response.getStatus());
		String location = response.getHeaderString("Location");
		Carrinho carrinhoCarregado = client.target(location).request().get(Carrinho.class);
		Assert.assertEquals("Tablet", carrinhoCarregado.getProdutos().get(0).getNome());
	}
}
