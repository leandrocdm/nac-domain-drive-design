package br.com.fiap.ddd.nac.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.ddd.nac.dao.VeiculoDAO;
import br.com.fiap.ddd.nac.exceptions.FormatoAnoException;
import br.com.fiap.ddd.nac.exceptions.FormatoPlacaException;
import br.com.fiap.ddd.nac.exceptions.NovaPlacaIgualException;
import br.com.fiap.ddd.nac.exceptions.PlacaJaExistenteException;
import br.com.fiap.ddd.nac.exceptions.PlacaNaoEncontradaExcepetion;
import br.com.fiap.ddd.nac.exceptions.PlacaNovaMenorVelhaException;
import br.com.fiap.ddd.nac.exportador.GeradorArquivo;
import br.com.fiap.ddd.nac.to.Veiculo;

/**
 * Classe de valida��o das regras de neg�cio para os m�todos.
 */

public class VeiculoBO {

	VeiculoDAO veiDAO = new VeiculoDAO();
	private static final String ARQUIVO = "D:/veiculoexportacao.csv";

	/**
	 * M�todo para corrigir modelo do objeto de tipo ve�culo
	 * @param modelo
	 */	
	public String corrigirModelo(String modelo) {
		String primeiraLetra = modelo.substring(0,1).toUpperCase();
		String modeloCorrigido = primeiraLetra + modelo.substring(1).toLowerCase();
		return modeloCorrigido;		
	}

	
	/**
	 * M�todo para valida��o de placa do objeto de tipo ve�culo
	 * @param veiculo,opcaoMetodo
	 * @throws SQLException, FormatoPlacaException, PlacaJaExistenteException, PlacaNaoEncontradaExcepetion
	 */	
	public void validarPlaca(Veiculo veiculo, String opcaoMetodo) throws SQLException, FormatoPlacaException, PlacaJaExistenteException, PlacaNaoEncontradaExcepetion {	
		int verificar;
		verificar = (int)veiDAO.validarPlaca(veiculo.getPlaca());

		if(veiculo.getPlaca().length() < 7 || veiculo.getPlaca().length() > 8) {
			throw new FormatoPlacaException();
		}

		if(opcaoMetodo.equals("validarPlacaExistenteTrue") && verificar > 0) {	
			throw new PlacaJaExistenteException();
		}	

		if(opcaoMetodo.equals("validarPlacaExistenteFalse") && verificar == 0) {
			throw new PlacaNaoEncontradaExcepetion();
		}

		if(opcaoMetodo.equals("validarInsert") && verificar > 0) {
			System.out.println("Veiculo: "+veiculo.getModelo()+" com a placa: "+veiculo.getPlaca()+ " foi inserido com sucesso!");
		}

		if(opcaoMetodo.equals("validarExclusao") && verificar == 0) {
			System.out.println("Veiculo com a placa: "+veiculo.getPlaca()+ " foi excluido com sucesso!");
		}
		if(opcaoMetodo.equals("validarAlteracao") && verificar > 0) {
			System.out.println("Placa alterada com sucesso!");
		}
	}

	/**
	 * M�todo para corrigir placa do objeto de tipo ve�culo
	 * @param placa
	 */	
	public String corrigirPlaca(String placa) {
		String novaPlaca;

		if(placa.length() == 7) {
			novaPlaca = placa.substring(0, 3)+"-"+placa.substring(3);
		}else {
			novaPlaca = placa;
		}
		return novaPlaca.toUpperCase();
	}

	public void validarAno(int ano, int maxAno) throws FormatoAnoException {
		if(ano < 1900 || ano > maxAno) {
			throw new FormatoAnoException();
		}
	}

	/**
	 * M�todo para validar altera��o de placa do objeto de tipo ve�culo
	 * @param placa, novaPlaca
	 * @throws NovaPlacaIgualException, PlacaNovaMenorVelhaException
	 */	
	public void validarPlacaAlteracao(String placa, String novaPlaca) throws NovaPlacaIgualException, PlacaNovaMenorVelhaException {
		int numPlaca, numPlacaNova = 0;
		numPlaca = Integer.valueOf(placa.substring(4));
		numPlacaNova = Integer.valueOf(novaPlaca.substring(4));

		if(placa.equals(novaPlaca)) {
			throw new NovaPlacaIgualException();
		}	

		if(numPlaca > numPlacaNova) {
			throw new PlacaNovaMenorVelhaException();
		}

	}
		
	/**
	 * M�todo para valida��o do objeto de tipo ve�culp antes do mesmo ser inserido no banco de dados
	 * @param veiculo
	 * @throws Exception
	 */	

	public void incluirVeiculo(Veiculo veiculo) throws Exception{
		try {
			veiculo.setModelo(corrigirModelo(veiculo.getModelo()));	
			validarPlaca(veiculo, "validarPlacaExistenteTrue");
			veiculo.setPlaca(corrigirPlaca(veiculo.getPlaca()));
			validarAno(veiculo.getAno(), Veiculo.getMaxAno());
			veiDAO.incluirVeiculo(veiculo);	
			validarPlaca(veiculo, "validarInsert");		
		}catch (FormatoPlacaException e) {
			e.printStackTrace();	
			System.out.println("N�o foi possivel inserir o veiculo!");
			System.exit(1);
		}catch(PlacaJaExistenteException ex) {
			ex.printStackTrace();
			System.out.println("N�o foi possivel inserir o veiculo!");
			System.exit(2);
		}catch(FormatoAnoException ex1) {
			ex1.printStackTrace();
			System.out.println("N�o foi possivel inserir o veiculo!");
			System.exit(3);
		}catch(Exception ex2) {
			ex2.printStackTrace();
			System.out.println("Ocorreu um erro inesperado, favor refazer a opera��o!");
			System.exit(4);
		}
	}

	/**
	 * M�todo para valida��o do objeto de tipo ve�culo antes do mesmo ser excluido no banco de dados
	 * @param veiculo
	 * @throws Exception
	 */	
	public void excluirVeiculo(Veiculo veiculo) throws Exception{
		try {
			veiculo.setPlaca(corrigirPlaca(veiculo.getPlaca()));
			validarPlaca(veiculo, "validarPlacaExistenteFalse");
			veiDAO.excluirVeiculo(veiculo.getPlaca());
			validarPlaca(veiculo, "validarExclusao");
		}catch (PlacaNaoEncontradaExcepetion e) {
			e.printStackTrace();
			System.out.println("N�o foi possivel excluir o veiculo!");
			System.exit(4);
		}catch(FormatoPlacaException ex) {
			ex.printStackTrace();	
			System.out.println("N�o foi possivel inserir o veiculo!");
			System.exit(1);
		}catch(Exception ex2) {
			ex2.printStackTrace();
			System.out.println("Ocorreu um erro inesperado, favor refazer a opera��o!");
			System.exit(4);
		}
	}
	
	
	/**
	 * M�todo para valida��o do objeto de tipo ve�culp antes do mesmo ser alterado no banco de dados
	 * @param veiculo, novaPlaca
	 * @throws Exception
	 */
	public void alterarVeiculo(Veiculo veiculo, String novaPlaca) throws Exception{
		try {
			veiculo.setPlaca(corrigirPlaca(veiculo.getPlaca()));
			novaPlaca = corrigirPlaca(novaPlaca);
			validarPlaca(veiculo, "validarPlacaExistenteFalse");
			validarPlacaAlteracao(veiculo.getPlaca(), novaPlaca);
			veiDAO.alterarVeiculo(veiculo.getPlaca(), novaPlaca);
			veiculo.setPlaca(novaPlaca);
			validarPlaca(veiculo, "validarAlteracao");
		}catch(PlacaNaoEncontradaExcepetion e) {
			e.printStackTrace();
			System.out.println("N�o foi possivel alterar a placa!");
			System.exit(8);
		}catch(NovaPlacaIgualException ex) {
			ex.printStackTrace();
			System.out.println("N�o foi possivel alterar a placa!");
			System.exit(9);
		}catch(PlacaNovaMenorVelhaException ex1) {
			ex1.printStackTrace();
			System.out.println("N�o foi possivel alterar a placa!");
			System.exit(10);
		}catch(FormatoPlacaException ex2) {
			ex2.printStackTrace();	
			System.out.println("N�o foi possivel inserir o veiculo!");
			System.exit(1);
		}catch(Exception ex3) {
			ex3.printStackTrace();
			System.out.println("Ocorreu um erro inesperado, favor refazer a opera��o!");
			System.exit(4);
		}
	}
	
	
	/**
	 * M�todo para realizar a listagem dos objetos de tipo ve�culo, cadastrados no banco de dados
	 * @throws Exception
	 */	
	public void listarVeiculo() throws Exception{
		
		ArrayList<Veiculo> lista = veiDAO.listarVeiculo();
		
		System.out.println("PLACA - MODELO/ANO MOTOR");
		for(Veiculo vei : lista) {
			System.out.println(vei.getPlaca()+" - "+vei.getModelo()+"/"+vei.getAno()+" "+vei.getMotor());
		}

	}
	

	/**
	 * M�todo para realizar a exporta��o do relat�rio de objetos de tipo ve�culo cadastrados no banco de dados.
	 * @throws Exception
	 */	
	public void exportarVeiculo() throws Exception{
		
		try {
			GeradorArquivo gerador = new GeradorArquivo(ARQUIVO);
			
			gerador.escreverLinha("Ano;Placa;Modelo;Motor");

			ArrayList<Veiculo> veiculoList = veiDAO.relatorioVeiculo();


			for(Veiculo vei : veiculoList) {
				gerador.escreverVeiculo(vei);
			}
			System.out.println("Arquivo gerado no caminho: "+ARQUIVO);
			gerador.fecharArquivo(); 
				
		} catch (IOException ex) {
			System.err.println("Erro ao abrir o arquivo(" + ARQUIVO + "): " + ex.getMessage());
		} catch (SQLException ex) {
			System.err.println("Erro ao executar SQL: " + ex.getMessage());
			System.exit(1);
		}
	}
}

