package br.com.fiap.ddd.nac.exceptions;

import br.com.fiap.ddd.nac.to.Veiculo;

/**
 *Esta classe pertence ao pacote de tratamento de exceções
 */

public class FormatoAnoException extends Exception{
	
	static Veiculo vei = new Veiculo();
	
	/**
	 *Este método realiza o tratamento da exceção de Formato de Ano.
	 */	
	public FormatoAnoException() {
		super("Formatado do ano invalido! Por favor, digite um ano entre 1900 até "+vei.getMaxAno()+" ");
	}

}
