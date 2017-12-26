package br.com.java8.aula1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do c�digo");
		palavras.add("caelum");
		
		//Ordenando da forma antiga
		Collections.sort(palavras, new ComparadorDeStringsPorTamanho());
		System.out.println(palavras);
		
		//Novo m�todo de ordena��o dispon�vel nas listas, por�m, ainda estamos passando uma classe inteira
		//Poder�amos passa uma classe an�nima tamb�m
		palavras.sort(new ComparadorDeStringsPorTamanho());
		System.out.println(palavras);
		
		//Novo m�todo que percorre uma lista, passamos uma classe com um m�todo que � executado em cada itera��o.
		palavras.forEach(new ConsumidorDeStrings());
	}
}
