package br.com.fiap.ddd.nac.to;

public class Veiculo {
	private int id;
	private String modelo;
	private String placa;
	private int ano;
	private String motor;
	static private int maxAno = 2019;


	/**
	 * @return o ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id o ID a ser atribuido
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return o modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo o modelo a ser atribuido
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return a placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa a placa a ser atribuida
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return o ano
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * @param ano o ano a ser atribuido
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * @return o motor
	 */
	public String getMotor() {
		return motor;
	}

	/**
	 * @param motor o motor a ser atribuido
	 */
	public void setMotor(String motor) {
		this.motor = motor;
	}

	/**
	 * @return o maxAno
	 */
	public static int getMaxAno() {
		return maxAno;
	}

	/**
	 * @param maxAno o maxAno a ser atribuido
	 */
	public static void setMaxAno(int maxAno) {
		Veiculo.maxAno = maxAno;
	}


	/**
	 *Este metodo e utilizado na gravacao do veiculo no arquivo .csv
	 *@return A representacao deste objeto como uma String
	 */	
	public String toString(){

		return (ano + ";" + placa + ";" + modelo + ";" + motor);
	
	}

}
