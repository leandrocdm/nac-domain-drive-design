package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exce��es
 */

public class PlacaNovaMenorVelhaException extends Exception{
	

	/**
	 *Este m�todo realiza a exce��o quando a Placa nova inserida � menor que a antiga j� cadastrada.
	 */	
	
	public PlacaNovaMenorVelhaException() {
		super("N�o foi possivel fazer a altera��o! Nova placa � menor que a antiga! ");
	}

}
