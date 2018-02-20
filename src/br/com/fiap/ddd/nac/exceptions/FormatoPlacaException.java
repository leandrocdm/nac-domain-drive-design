package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exceções
 */

public class FormatoPlacaException extends Exception{
	
	/**
	 *Este método realiza o tratamento da exceção de Formato de Placa.
	 */	
	public FormatoPlacaException() {
		super("Formato de Placa invalida! Modelo de placa legivel => AAA-1234 ");
	}

}
