package br.com.fiap.ddd.nac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.ddd.nac.to.Veiculo;


/**
 * Esta � a classe que realiza a persistencia com o banco de dados Oracle
 */

public class VeiculoDAO {

	Connection conn = null;

	
	/**
	 *Este m�todo realiza a valida��o de placa de ve�culos cadastrados no banco de dados
	 *@param placa
	 *@throws SQLException
	 */
	public int validarPlaca(String placa) throws SQLException{

		int resultadoPlaca;

		try {
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement placaSelect = conn
					.prepareStatement("SELECT PLACA FROM TB_VEICULO where placa = ?");		

			placaSelect.setString(1, placa);

			resultadoPlaca = placaSelect.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(
					"Ocorreu algum erro com a conex�o do banco!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(
							"Erro ao fechar a conexao com o banco de dados!", e);
				}
			}

		}
		return resultadoPlaca;
	} 
	
	
	/**
	 *Este m�todo inclui um objeto de tipo ve�culo no banco de dados
	 *@param veiculo
	 *@throws SQLException
	 */
	public void incluirVeiculo(Veiculo veiculo) throws SQLException{
		try {
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement veiculoInsert = conn
					.prepareStatement("INSERT INTO TB_VEICULO(id_veiculo, modelo, placa, ano, motor) VALUES (SQ_VEICULO.nextval, ?, ?, ?, ?)");

			veiculoInsert.setString(1, veiculo.getModelo());
			veiculoInsert.setString(2, veiculo.getPlaca());
			veiculoInsert.setInt(3, veiculo.getAno());
			veiculoInsert.setString(4, veiculo.getMotor());

			veiculoInsert.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(
					"Ocorreu algum erro com a conex�o do banco!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(
							"Erro ao fechar a conexao com o banco de dados!", e);
				}
			}

		}

	}

	
	/**
	 *Este m�todo exclui um objeto de tipo ve�culo no banco de dados
	 *@param placa
	 *@throws SQLException
	 */
	
	public void excluirVeiculo(String placa) throws SQLException {
		try {
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement veiculoDelete = conn
					.prepareStatement("DELETE FROM TB_VEICULO WHERE PLACA = ?");

			veiculoDelete.setString(1, placa);

			int qtdeAfetados = veiculoDelete.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(
					"Ocorreu algum erro com a conex�o do banco!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(
							"Erro ao fechar a conexao com o banco de dados!", e);
				}
			}

		}

	}
	
	
	/**
	 *Este m�todo altera as informa��es do objeto de tipo Ve�culo no banco de dados
	 *@param placa, novaPlaca
	 *@throws SQLException
	 */
	
	public void alterarVeiculo(String placa, String novaPlaca) throws SQLException {
		try {
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement alterarVeiculo = conn
					.prepareStatement("UPDATE TB_VEICULO SET PLACA = ? WHERE PLACA = ?");

			alterarVeiculo.setString(1,novaPlaca);
			alterarVeiculo.setString(2, placa);

			alterarVeiculo.executeQuery();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(
					"Ocorreu algum erro com a conex�o do banco!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(
							"Erro ao fechar a conexao com o banco de dados!", e);
				}
			}

		}

	}
	
	
	/**
	 * Seleciona todos registros da tabela TB_VEICULO.
	 * @return Uma lista ArrayList de objetos do tipo Veiculo
	 * @throws SQLException
	 * @see ArrayList
	 * @see Veiculo.
	 */
	public ArrayList<Veiculo> listarVeiculo() throws SQLException {
		conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement listarQuery = conn.prepareStatement("SELECT * FROM TB_VEICULO");
		ResultSet rs = listarQuery.executeQuery();

		ArrayList<Veiculo> listagem = new ArrayList<Veiculo>();

		while(rs.next()){
			Veiculo vei = new Veiculo();

			vei.setAno(rs.getInt("Ano"));			
			vei.setPlaca(rs.getString("Placa"));
			vei.setModelo(rs.getString("Modelo"));
			vei.setMotor(rs.getString("Motor"));

			listagem.add(vei);

		}

		return listagem;

	}
	
	
	/**
	 * Seleciona todos registros da tabela TB_VEICULO.
	 * @return Uma lista ArrayList de objetos Veiculo cadastrados com ano de 2017, ordenados por placa e modelo.
	 * @throws SQLException
	 * @see ArrayList
	 * @see Veiculo
	 */
	public ArrayList<Veiculo> relatorioVeiculo() throws SQLException {
		conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement query = conn
				.prepareStatement("SELECT * FROM TB_VEICULO WHERE ANO = '2017' ORDER BY PLACA,MODELO");		
		ResultSet rs = query.executeQuery();

		ArrayList<Veiculo> retorno = new ArrayList<Veiculo>();

		while(rs.next()){
			Veiculo veiculo = new Veiculo();

			veiculo.setAno(rs.getInt("Ano"));			
			veiculo.setPlaca(rs.getString("Placa"));
			veiculo.setModelo(rs.getString("Modelo"));
			veiculo.setMotor(rs.getString("Motor"));

			retorno.add(veiculo);

		}

		return retorno;

	}
}

