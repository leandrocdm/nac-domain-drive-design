package br.com.fiap.ddd.nac.console;

import java.util.Scanner;

/**
 *Classe principal do projeto, retorna a instancia da classe de visualiza��o do Menu com os m�todos de utiliza��o do usu�rio.
 *@param String[] args
 *@throws Exception
 */

public class MainVeiculo {

	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);

		Menu m = new Menu();
		
		m.opcaoEscolhida(m.mostrarMenu());


	}
}
