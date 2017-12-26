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
		
		//Uma nova feature do java 8 é a api de datas
		//Veja abaixo como ficou simples criar a data atual com LocalDate.now()
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		//Temos também o método of() que tem muitas versões onde passamos os valores que queremos que a data tenha
		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
		
		//Operações com datas também são possíveis
		System.out.println(olimpiadasRio.getYear() - hoje.getYear());
		
		//A classe Period nos da alguns métodos para manipular as datas
		//Abaixo uma forma de pegar o período entre duas datas.
		Period periodo = Period.between(hoje, olimpiadasRio);
		
		System.out.println(periodo.getDays());
		
		//Adicionar anos as nossas datas ficou extremamente fácil.
		//Lembrando que podemos adicionar dias, meses e etc também.
		System.out.println(olimpiadasRio.plusYears(4));
		
		//Formatar as datas para String e vice-versa também ficou fácil
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		//Chamada encadeada de métodos.
		//Um ponto importante é que as classes de data e time da nova API são imutáveis,
		//Ou seja, se quisermos gravar a operação feita temos que reatribuir à variável.
		System.out.println(olimpiadasRio.plusYears(4).format(formatador));
		
		//Classe para manipular datas com horário
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
		
		//Transformando uma data que tem horário em uma que é só data
		System.out.println(agora.toLocalDate());
		
		//Transformando uma data em uma data com horário
		System.out.println(hoje.atTime(LocalTime.now()));
		
		//No YearMonth temos uma estrutura somente com mês e ano, isso evita muitas gambiarras.
		System.out.println(YearMonth.now());
		
		//Classe só para tempo (LocalTime)
		System.out.println(LocalTime.of(15, 30));
	}
}
