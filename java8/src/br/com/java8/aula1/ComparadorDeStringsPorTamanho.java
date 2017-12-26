package br.com.java8.aula1;

import java.util.Comparator;

//Classe Comparadora que compara o tamanho de duas Strings
public class ComparadorDeStringsPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return 1;
		} else if (s1.length() < s2.length()) {
			return -1;
		} else {
			return 0;
		}
	}
}
