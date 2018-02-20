package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(query="select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta"
		+ " and m.tipo = :pTipo" + " group by (m.data)", name="MediasPorDiaETipo")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private BigDecimal valor;
	
	//Tipo Enum usamos a anota��o @Enumerated para dizer para o JPA tratar esse campo como Enum
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;
	
	//Usamos a anota��o @Temporal(TemporalType.TIMESTAMP) para dizer que queremos gravar a data e a hora
	//(TemporalType.DATE) para somente data
	//(TemporalType.TIME) para somente hora
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	private String descricao;
	
	//Relacionamento bi-direcional com a classe Conta
	//Essa � a parte forte do relacionamento
	@ManyToOne
	private Conta conta;
	
	@ManyToMany
	private List<Categoria> categorias;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}