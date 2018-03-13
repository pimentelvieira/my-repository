package br.com.caelum.estoque.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TesteServicoWeb2 {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8080/estoquews-web/EstoqueWS?wsdl");
		QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS");
		
		Service service = Service.create(url, qname);
		
		EstoqueWS cliente = service.getPort(EstoqueWS.class);
		
		Filtros filtros = new Filtros();
		Filtro filtro = new Filtro();
		filtro.setNome("Iphone");
		filtro.setTipo("Livro");
		filtros.getFiltro().add(filtro);
		ListaItens itens = cliente.todosOsItens(filtros);
		
		for (Item item : itens.item) {
            System.out.println(item.getNome());
        }
	}
}
