package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exceções
 */

public class PlacaNovaMenorVelhaException extends Exception{
	

	/**
	 *Este método realiza a exceção quando a Placa nova inserida é menor que a antiga já cadastrada.
	 */	
	
	public PlacaNovaMenorVelhaException() {
		super("Não foi possivel fazer a alteração! Nova placa é menor que a antiga! ");
	}

}
