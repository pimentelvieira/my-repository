package br.com.java8.aula3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("casa do código");
		palavras.add("alura online");
		palavras.add("caelum");
		System.out.println(palavras);
		
		//Uma forma mais sucinta de escrever certos lambdas é chamada de Method Reference
		//Com ela temos uma chamada "implícita", veja abaixo que o método Comparator.comparing recebe uma interface funcional
		//Chamada Function, essa interface também utiliza Generics Function<T, U>, dado um T retorne U.
		//Veja que no Method Reference abaixo, temos dado uma String, retorne um int/Integer
		//Essa conversão é feita automaticamente, veja que em nenhum lugar falamos que o Function recebido pelo
		//Comparator.comparing é <String, Integer> o Java descrobre isso pra gente.
		Comparator<String> comparador = Comparator.comparing(String::length);
		palavras.sort(comparador);
		
		//Outro exemplo de Method Reference, nesse caso como palavras é uma List<String> podemos usar o Method Reference a nosso favor
		//Nesse caso o System.out::println, significa que o método será chamado da seguinte forma System.out.println(Object) que no nosso
		//Caso é uma String, mas poderia ser qualquer outro objeto.
		palavras.forEach(System.out::println);
	}
}
