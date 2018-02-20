package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exce��es
 */

public class FormatoPlacaException extends Exception{
	
	/**
	 *Este m�todo realiza o tratamento da exce��o de Formato de Placa.
	 */	
	public FormatoPlacaException() {
		super("Formato de Placa invalida! Modelo de placa legivel => AAA-1234 ");
	}

}
