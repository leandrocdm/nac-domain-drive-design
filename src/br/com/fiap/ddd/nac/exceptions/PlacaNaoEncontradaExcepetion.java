package br.com.fiap.ddd.nac.exceptions;


/**
 *Esta classe pertence ao pacote de tratamento de exceções
 */

public class PlacaNaoEncontradaExcepetion extends Exception{
	
	/**
	 *Este método realiza a exceção de placa não encontrada.
	 */	
	
	
	public PlacaNaoEncontradaExcepetion() {
		super("Placa invalida! Não existe nenhum veiculo com essa placa! ");
	}

}
