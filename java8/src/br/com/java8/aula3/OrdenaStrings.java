package br.com.java8.aula3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("casa do c�digo");
		palavras.add("alura online");
		palavras.add("caelum");
		System.out.println(palavras);
		
		//Uma forma mais sucinta de escrever certos lambdas � chamada de Method Reference
		//Com ela temos uma chamada "impl�cita", veja abaixo que o m�todo Comparator.comparing recebe uma interface funcional
		//Chamada Function, essa interface tamb�m utiliza Generics Function<T, U>, dado um T retorne U.
		//Veja que no Method Reference abaixo, temos dado uma String, retorne um int/Integer
		//Essa convers�o � feita automaticamente, veja que em nenhum lugar falamos que o Function recebido pelo
		//Comparator.comparing � <String, Integer> o Java descrobre isso pra gente.
		Comparator<String> comparador = Comparator.comparing(String::length);
		palavras.sort(comparador);
		
		//Outro exemplo de Method Reference, nesse caso como palavras � uma List<String> podemos usar o Method Reference a nosso favor
		//Nesse caso o System.out::println, significa que o m�todo ser� chamado da seguinte forma System.out.println(Object) que no nosso
		//Caso � uma String, mas poderia ser qualquer outro objeto.
		palavras.forEach(System.out::println);
	}
}
