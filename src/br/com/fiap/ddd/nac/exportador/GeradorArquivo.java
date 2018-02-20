package br.com.fiap.ddd.nac.exportador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.fiap.ddd.nac.to.Veiculo;


/**
 *Classe responsavel por gravar o arquivo de saida 
 */

public class GeradorArquivo {
	/** manipuladores de arquivo */
	private FileWriter outputStream;
	private PrintWriter  arquivoSaida;
	
	
	/**
	 * Abre arquivo para escrita sequencial
	 * @param caminhoArquivo
	 * @throws IOException
	 */	
	public GeradorArquivo(String caminhoArquivo) throws IOException {
		//instancia objetos
		this.outputStream = new FileWriter(caminhoArquivo);
		this.arquivoSaida = new PrintWriter(outputStream);
	}

	
	/**
	 * Escreve linha
	 * @param linha
	 * @throws IOException
	 */	
	public void escreverLinha(String linha) {

		arquivoSaida.println(linha);
	}
	

	/**
	 * Escreve um veiculo no arquivo.
	 * @param Veiculo
	 * @throws IOException
	 * @see Veiculo
	 */
	public void escreverVeiculo(Veiculo veiculo) {	
		//<ANO>;<PLACA>;<MODELO>;<MOTOR>;
		arquivoSaida.println(veiculo.toString());
	}

	/**
	 * Fecha o arquivo de escrita sequencial
	 * @throws IOException
	 */		
	public void fecharArquivo() throws IOException{
		arquivoSaida.close();
		outputStream.close();
	}

}
