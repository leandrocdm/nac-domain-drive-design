package br.com.fiap.ddd.nac.exceptions;


/**
 *Esta classe pertence ao pacote de tratamento de exce��es
 */

public class PlacaNaoEncontradaExcepetion extends Exception{
	
	/**
	 *Este m�todo realiza a exce��o de placa n�o encontrada.
	 */	
	
	
	public PlacaNaoEncontradaExcepetion() {
		super("Placa invalida! N�o existe nenhum veiculo com essa placa! ");
	}

}
