package br.com.caelum.estoque.client;

public class TesteServicoWeb {

	public static void main(String[] args) {
		EstoqueWS client = new EstoqueWS_Service().getEstoqueWSImpPort();
		Filtros filtros = new Filtros();
		Filtro filtro = new Filtro();
		filtro.setNome("Iphone");
		filtro.setTipo("Livro");
		filtros.getFiltro().add(filtro);
		ListaItens itens = client.todosOsItens(filtros);
		System.out.println(itens);
	}

}
