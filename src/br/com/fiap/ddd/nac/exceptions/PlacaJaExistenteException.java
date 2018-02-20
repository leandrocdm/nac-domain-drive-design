package br.com.fiap.ddd.nac.exceptions;

/**
 *Esta classe pertence ao pacote de tratamento de exce��es
 */

public class PlacaJaExistenteException extends Exception{
	
	/**
	 *Este m�todo realiza a exce��o de placa j� existente.
	 */	
	
	
	public PlacaJaExistenteException() {
		super("Placa invalida! Já existe um veiculo com essa placa! ");
	}

}
