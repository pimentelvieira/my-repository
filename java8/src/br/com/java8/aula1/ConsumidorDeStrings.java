package br.com.java8.aula1;

import java.util.function.Consumer;

//Classe que implementa a interface Consumer
//O objetivo dessa classe é executar alguma coisa no único método disponível nela.
//Recebe uma classe com Generics, essa classe será o tipo do único parâmetro do método accept
public class ConsumidorDeStrings implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
}
