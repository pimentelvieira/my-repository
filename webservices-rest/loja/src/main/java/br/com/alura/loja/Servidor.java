package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

//Classe utilizado como servidor que suportará nosso serviço de carrinhos
public class Servidor {

	public static void main(String[] args) throws IOException {
		HttpServer server = inicializa();
		System.out.println("Servidor rodando");
		System.in.read();
		server.stop();
	}
	public static HttpServer inicializa() {
		//Classe de config para varrer nosso pacote e procurar os recursos
		ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
		//Cria uma URI para o servidor
		URI uri = URI.create("http://localhost:8080/");
		//Criação de um server http pelo Grizzly
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		
		return server;
	}
}
