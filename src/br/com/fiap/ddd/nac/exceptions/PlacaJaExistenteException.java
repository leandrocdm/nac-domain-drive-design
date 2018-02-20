package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exceções
 */

public class PlacaJaExistenteException extends Exception{
	
	/**
	 *Este método realiza a exceção de placa já existente.
	 */	
	
	
	public PlacaJaExistenteException() {
		super("Placa invalida! JÃ¡ existe um veiculo com essa placa! ");
	}

}
