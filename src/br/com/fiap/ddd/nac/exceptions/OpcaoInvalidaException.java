package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exceções
 */

public class OpcaoInvalidaException extends Exception{
	
	/**
	 *Este método realiza a exceção de opção de menu inválida.
	 */	
	
	public OpcaoInvalidaException() {
		super("Opção invalida! Digite um numero de 1 a 6" );
	}

}
