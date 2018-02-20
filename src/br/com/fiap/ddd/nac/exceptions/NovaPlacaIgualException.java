package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exceções
 */

public class NovaPlacaIgualException extends Exception{
	
	/**
	 *Este método realiza o tratamento da exceção de placas iguais.
	 */	
	public NovaPlacaIgualException() {
		super("Não foi possivel fazer a alteração! Nova placa igual a antiga!");
	}

}
