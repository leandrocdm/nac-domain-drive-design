package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exce��es
 */

public class OpcaoInvalidaException extends Exception{
	
	/**
	 *Este m�todo realiza a exce��o de op��o de menu inv�lida.
	 */	
	
	public OpcaoInvalidaException() {
		super("Op��o invalida! Digite um numero de 1 a 6" );
	}

}
