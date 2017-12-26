package br.com.java8.aula2;

import java.util.ArrayList;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		System.out.println(palavras);
		
		//Exemplo usando Lambda
		//Nesse caso forEach recebe uma interface funcional
		//Ou seja, toda interface funcional pode ser representada na forma de um Lambda
		//Nesse caso, para cada s que é uma String dentro de palavras, o System.out.println(s); é executado
		palavras.forEach(s -> System.out.println(s));
		
		//Outro exemplo, o método sort recebe a interface Comparator, ela é uma interface funcional também.
		//Logo, temos, para cada duas Strings (s1, e s2), compare utilizando Integer.compare(s1.length(), s2.length())
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.forEach(s -> System.out.println(s));
		
		//Outro exemplo, o new Thread() recebe a interface Runnable que possui um único método (é uma interface funcional)
		//O único método existente em Runnable não recebe parâmetros e executa algo
		//Veja que dessa forma, do lado esquerdo do Lambda não existe nada, temos um parênteses vazio.
		//Dessa forma, temos que o que vai do lado esquerdo do lambda são os parâmetros recebidos pelo método da inteface funcional
		//O que vai do lado direito é a implementação que vamos dar ao método da interface funcional, se é o método retornasse algo
		//A parte à direita do lambda também teria que retornar, é como acontece no método sort acima
		//O método compare da interface Comparator recebe dois parâmetros do tipo Generico e retorna um int
		new Thread(() -> System.out.println("")).start();
	}
}
