package br.com.java8.aula5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
		
		//No Java 8 Agora temos esse objeto Optional, que nos ajuda a trabalhar com os objetos nulos
		//Abaixo com o método findAny() retornamos um dos objetos do nosso Stream filtrado.
		Optional<Curso> optionalCurso = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.findAny();
		
		//Aqui pegamos o primeiro elemento.
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst();
		
		//Veja que temos um método get() no Optional, caso não tenha retorno algum, é retornada uma NoSuchElementException
		Curso curso = optionalCurso.get();
		
		System.out.println(curso);
		
		//O ifPresent recebe um Lambda e executa somente se existir algum elemento no Optional
		optionalCurso.ifPresent(System.out::println);
		
		//O método orElse retorna o objeto passado no parâmetro caso ele não encontre nada dentro do Optional
		curso = optionalCurso.orElse(null);
		
		System.out.println(curso);
		
		//Abaixo um caso interessante, o método average() retorna um OptionalDouble, ou seja, no cálculo da média
		//Temos muitos casos possíveis: nenhum elemento encontrado, divisão por zero, com o Optional nos livramos de receber
		//esses casos que não são interessantes para a nossa implementação.
		OptionalDouble average = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.average();
		
		System.out.println(average.getAsDouble());
		
		//Para transformarmos o resultado do filter em uma lista precisamos do método collect()
		//Ele recebe um Collector, no caso abaixo, o método estático toList() nos retorna um List
		//Mas temos também para Map, Set...
		cursos = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
		
		//Abaixo temos o collect utilizando um Map, e mais...
		//Veja que passamos dois lambdas como argumento, o primeiro quer dizer que as chaves serão
		//Geradas a partir dos nomes dos cursos, o segundo quer dizer que os valores serão
		//Gerados a partir dos alunos dos cursos.
		Map<String, Integer> mapa = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toMap(Curso::getNome, Curso::getAlunos));
		
		//Veja que o forEach do tipo map é diferente, passamos dois parâmetros no lambda.
		mapa.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
	}
}
