package br.com.caelum.estoque.exception;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name="AutorizacaoFault")
public class AutorizacaoException extends Exception {

	public AutorizacaoException(String mensagem) {
		super(mensagem);
	}
	
	public InfoFault getFaultInfo() {
		return new InfoFault("Token inválido", new Date());
	}
}
