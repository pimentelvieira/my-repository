package br.com.java8.aula1;

import java.util.function.Consumer;

//Classe que implementa a interface Consumer
//O objetivo dessa classe � executar alguma coisa no �nico m�todo dispon�vel nela.
//Recebe uma classe com Generics, essa classe ser� o tipo do �nico par�metro do m�todo accept
public class ConsumidorDeStrings implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
}
