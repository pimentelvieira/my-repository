package br.com.java8.aula6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		
		//Uma nova feature do java 8 � a api de datas
		//Veja abaixo como ficou simples criar a data atual com LocalDate.now()
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		//Temos tamb�m o m�todo of() que tem muitas vers�es onde passamos os valores que queremos que a data tenha
		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
		
		//Opera��es com datas tamb�m s�o poss�veis
		System.out.println(olimpiadasRio.getYear() - hoje.getYear());
		
		//A classe Period nos da alguns m�todos para manipular as datas
		//Abaixo uma forma de pegar o per�odo entre duas datas.
		Period periodo = Period.between(hoje, olimpiadasRio);
		
		System.out.println(periodo.getDays());
		
		//Adicionar anos as nossas datas ficou extremamente f�cil.
		//Lembrando que podemos adicionar dias, meses e etc tamb�m.
		System.out.println(olimpiadasRio.plusYears(4));
		
		//Formatar as datas para String e vice-versa tamb�m ficou f�cil
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		//Chamada encadeada de m�todos.
		//Um ponto importante � que as classes de data e time da nova API s�o imut�veis,
		//Ou seja, se quisermos gravar a opera��o feita temos que reatribuir � vari�vel.
		System.out.println(olimpiadasRio.plusYears(4).format(formatador));
		
		//Classe para manipular datas com hor�rio
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
		
		//Transformando uma data que tem hor�rio em uma que � s� data
		System.out.println(agora.toLocalDate());
		
		//Transformando uma data em uma data com hor�rio
		System.out.println(hoje.atTime(LocalTime.now()));
		
		//No YearMonth temos uma estrutura somente com m�s e ano, isso evita muitas gambiarras.
		System.out.println(YearMonth.now());
		
		//Classe s� para tempo (LocalTime)
		System.out.println(LocalTime.of(15, 30));
	}
}
