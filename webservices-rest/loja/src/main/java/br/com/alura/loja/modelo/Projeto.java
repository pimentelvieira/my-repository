package br.com.alura.loja.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@XmlRootElement //Para utilizar JAX-B
@XmlAccessorType(XmlAccessType.FIELD) //Para utilizar JAX-B
public class Projeto {

	private String nome;
	private long id;
	private int anoDeInicio;
	
	public Projeto() {
	}
	
	public Projeto(long id, String nome, int anoDeInicio) {
		this.id = id;
		this.nome = nome;
		this.anoDeInicio = anoDeInicio;
	}

	public String getNome() {
		return nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAnoDeInicio() {
		return anoDeInicio;
	}
	public String toXML() {
    	return new XStream().toXML(this);
    }

	public String toJson() {
		return new Gson().toJson(this);
	}
}
