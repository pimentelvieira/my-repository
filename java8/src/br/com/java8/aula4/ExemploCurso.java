package br.com.java8.aula4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class Curso {
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}
	public String getNome() {
		return nome;
	}
	public int getAlunos() {
		return alunos;
	}
	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", alunos=" + alunos + "]";
	}
}

public class ExemploCurso {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Javascript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		cursos.forEach(System.out::println);
		System.out.println();
		
		//Utiliza��o do Stream, ele nos d� um fluxo de dados onde podemos executar v�rias opera��es, dentre elas
		//Filtar o conte�do da lista, o m�todo filter() recebe um Lambda e filtra com base no retorno boolean dele
		//Conforme abaixo, filtramos e deixamos somente os cursos com 100 ou mais alunos
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.forEach(System.out::println);
		System.out.println();
		
		//O m�todo map() tamb�m recebe um lambda, nesse caso, ser� gerada uma lista de valores os quais foram passados no Lambda
		//No exemplo abaixo, ser� gerada uma lista somente com o n�mero de alunos
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.map(Curso::getAlunos)
			.forEach(System.out::println);
		System.out.println();
		
		//O m�todo map() tem vers�es mais espec�ficas, abaixo temos o mapToInt que funciona melhor quando queremos trabalhar com inteiros
		//Veja que o mapToInt retorna um IntStream e n�o um Stream gen�rico
		IntStream intStream = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos);
		intStream.forEach(System.out::println);
		System.out.println();
		
		//O IntStream tem m�todos espec�ficos capazes de fazer algumas opera��es,
		//Abaixo fizemos a soma de todos os valores do stream
		intStream = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos);
		System.out.println(intStream.sum());
	}
}
