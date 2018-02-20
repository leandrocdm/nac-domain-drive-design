package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exce��es
 */

public class NovaPlacaIgualException extends Exception{
	
	/**
	 *Este m�todo realiza o tratamento da exce��o de placas iguais.
	 */	
	public NovaPlacaIgualException() {
		super("N�o foi possivel fazer a altera��o! Nova placa igual a antiga!");
	}

}
