package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.modelo.Projeto;

public class ProjetoTest {

	private HttpServer server;
	
	@Before
	public void before() {
		server = Servidor.inicializa();
	}
	
	@After
	public void after() {
		//Mata o servidor http
		server.stop();
	}
	
	@Test
	public void testaQueAConexaoComOServidorFunciona() {
		//Cria o client
		Client client = ClientBuilder.newClient();
		
		//Configura o target, ou seja, onde a nossa request irá bater
		WebTarget target = client.target("http://localhost:8080");
		
		//Pega o conteúdo de retorno para um path específico que vem o localhost
		Projeto projeto = target.path("/projetos/1").request().get(Projeto.class);
		
		Assert.assertEquals("Minha loja", projeto.getNome());
		
	}
}
