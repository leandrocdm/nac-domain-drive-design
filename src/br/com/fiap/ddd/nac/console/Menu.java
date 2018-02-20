package br.com.fiap.ddd.nac.console;

import java.sql.SQLException;
import java.util.Scanner;
import br.com.fiap.ddd.nac.bo.VeiculoBO;
import br.com.fiap.ddd.nac.to.Veiculo;

public class Menu {

	Scanner input = new Scanner(System.in);
	VeiculoBO veiBO = new VeiculoBO();

	
	
	/**
	 *Este m�todo retorna o menu de op��es de escolha
	 */
	public int mostrarMenu(){
		System.out.println("**** 1 - INCLUIR  ******");
		System.out.println("**** 2 - EXCLUIR  ******");
		System.out.println("**** 3 - ALTERAR  ******");
		System.out.println("**** 4 - LISTAR   ******");
		System.out.println("**** 5 - EXPORTAR ******");
		System.out.println("**** 6 - SAIR     ******");
		return input.nextInt();

	}

	/**
	 *Este m�todo retorna as a��es para as op��es do menu
	 *@param retorno
	 *@throws Exception
	 */
	public void opcaoEscolhida(int retorno) throws Exception{

		switch(retorno){
		case 1:
			incluirVeiculo();
			opcaoEscolhida(mostrarMenu());
			break;
		case 2:
			excluirVeiculo();
			opcaoEscolhida(mostrarMenu());
			break;
		case 3:
			alterarVeiculo();
			opcaoEscolhida(mostrarMenu());
			break;
		case 4:
			veiBO.listarVeiculo();
			opcaoEscolhida(mostrarMenu());
			break;
		case 5:
			veiBO.exportarVeiculo();
			opcaoEscolhida(mostrarMenu());
			break;
		case 6:
			System.out.println("Saindo..");
			System.exit(0);
			break;
		default:
			System.out.println("Op��o invalida!");
			opcaoEscolhida(mostrarMenu());
		}
	}

	/**
	 *Este m�todo solicita ao usu�rio as informa��es para inclus�o de um novo ve�culo
	 *@throws Exception
	 */
	public void incluirVeiculo() throws Exception{

		Veiculo veiculo = new Veiculo();

		System.out.println("Digite o modelo do veiculo:");
		veiculo.setModelo(input.next());
		System.out.println("Digite a placa do veiculo:");
		veiculo.setPlaca(input.next());
		System.out.println("Digite o ano do veiculo:");
		veiculo.setAno(input.nextInt());
		System.out.println("Digite o motor do veiculo");
		veiculo.setMotor(input.next());

		veiBO.incluirVeiculo(veiculo);

	}
	
	/**
	 *Este m�todo solicita ao usu�rio as informa��es para exclu��o de um ve�culo existente
	 *@throws Exception
	 */
	public void excluirVeiculo() throws Exception{
		Veiculo veiculo = new Veiculo();
		System.out.println("Digite a placa do veiculo:");
		veiculo.setPlaca(input.next());

		veiBO.excluirVeiculo(veiculo);

	}
	
	/**
	 *Este m�todo solicita ao usu�rio as informa��es para altera��o de um ve�culo existente
	 *@throws Exception
	 */
	public void alterarVeiculo() throws Exception{
		Veiculo veiculo = new Veiculo();

		System.out.println("Digite a placa do veiculo:");
		veiculo.setPlaca(input.next());

		System.out.println("Digite a nova placa: ");
		String novaPlaca = input.next();

		veiBO.alterarVeiculo(veiculo, novaPlaca);

		opcaoEscolhida(mostrarMenu());

	}

}