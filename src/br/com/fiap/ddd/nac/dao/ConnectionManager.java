package br.com.fiap.ddd.nac.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	/**
	 * Essa classe será responsavel por controlar o acesso ao banco de dados ORACLE.
	 */
	
	class ConnectionManager {
		//Variavel constante de instancia do Driver de conexao com a oracle (JDBC)
		private static ConnectionManager instance;
		
			
		private ConnectionManager() throws ClassNotFoundException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}
		
		/**
		 * Realiza instancia com o driver do banco de dados.
		 * @throws SQLException
		 */
		public static ConnectionManager getInstance() throws SQLException{

			try{
				if (instance == null) {
				instance = new ConnectionManager();
				}
			
			}
			catch(ClassNotFoundException e){
				
				throw new SQLException("O Driver JDBC nao foi encontrado!");
				
			}
			
			return instance;
		}
		
		
		/**
		 * Abre a conexao com o banco de dados.
		 * @throws SQLException
		 */
		public Connection getConnection() throws SQLException {
			//
			//Variaveis constantes de parametros para a conexao com o BD
			//
			String usuario = "RM77327";
			String senha = "140297";
			String jdbcUrl = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			
			try{

				return DriverManager.getConnection(jdbcUrl, usuario, senha);
		
			}
			catch (SQLException e) {
				
				e.printStackTrace();
				throw new SQLException("Não foi possível abrir conexão com o Banco de Dados.", e);

			}
			
		}

	}
	

