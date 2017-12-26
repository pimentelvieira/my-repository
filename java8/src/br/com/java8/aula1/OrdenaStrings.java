package br.com.java8.aula1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		//Ordenando da forma antiga
		Collections.sort(palavras, new ComparadorDeStringsPorTamanho());
		System.out.println(palavras);
		
		//Novo método de ordenação disponível nas listas, porém, ainda estamos passando uma classe inteira
		//Poderíamos passa uma classe anônima também
		palavras.sort(new ComparadorDeStringsPorTamanho());
		System.out.println(palavras);
		
		//Novo método que percorre uma lista, passamos uma classe com um método que é executado em cada iteração.
		palavras.forEach(new ConsumidorDeStrings());
	}
}
