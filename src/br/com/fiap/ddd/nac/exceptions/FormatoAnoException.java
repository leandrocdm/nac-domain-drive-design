package br.com.fiap.ddd.nac.exceptions;

import br.com.fiap.ddd.nac.to.Veiculo;

/**
 *Esta classe pertence ao pacote de tratamento de exce��es
 */

public class FormatoAnoException extends Exception{
	
	static Veiculo vei = new Veiculo();
	
	/**
	 *Este m�todo realiza o tratamento da exce��o de Formato de Ano.
	 */	
	public FormatoAnoException() {
		super("Formatado do ano invalido! Por favor, digite um ano entre 1900 at� "+vei.getMaxAno()+" ");
	}

}
