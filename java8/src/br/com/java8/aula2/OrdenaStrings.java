package br.com.java8.aula2;

import java.util.ArrayList;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do c�digo");
		palavras.add("caelum");
		System.out.println(palavras);
		
		//Exemplo usando Lambda
		//Nesse caso forEach recebe uma interface funcional
		//Ou seja, toda interface funcional pode ser representada na forma de um Lambda
		//Nesse caso, para cada s que � uma String dentro de palavras, o System.out.println(s); � executado
		palavras.forEach(s -> System.out.println(s));
		
		//Outro exemplo, o m�todo sort recebe a interface Comparator, ela � uma interface funcional tamb�m.
		//Logo, temos, para cada duas Strings (s1, e s2), compare utilizando Integer.compare(s1.length(), s2.length())
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.forEach(s -> System.out.println(s));
		
		//Outro exemplo, o new Thread() recebe a interface Runnable que possui um �nico m�todo (� uma interface funcional)
		//O �nico m�todo existente em Runnable n�o recebe par�metros e executa algo
		//Veja que dessa forma, do lado esquerdo do Lambda n�o existe nada, temos um par�nteses vazio.
		//Dessa forma, temos que o que vai do lado esquerdo do lambda s�o os par�metros recebidos pelo m�todo da inteface funcional
		//O que vai do lado direito � a implementa��o que vamos dar ao m�todo da interface funcional, se � o m�todo retornasse algo
		//A parte � direita do lambda tamb�m teria que retornar, � como acontece no m�todo sort acima
		//O m�todo compare da interface Comparator recebe dois par�metros do tipo Generico e retorna um int
		new Thread(() -> System.out.println("")).start();
	}
}
