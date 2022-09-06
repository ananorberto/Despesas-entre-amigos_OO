package model;

/**
 * Classe Pessoa que contem os atributos de uma pessoa.
 * 
 * @author Ana Beatriz, Leonardo
 * @since 2022
 * @version 1.0
 * 
 */
public class Pessoa {

	private String cpf;
	private String nome;
	private int id;
	private double totalDespesa = 0;
	private double saldo;

	/**
	 * Construtor responsavel por cadastrar o CPF, nome e ID de uma pessoa.
	 * 
	 * @param cpf  String Recebe o CPF de uma pessoa.
	 * @param nome String Recebe o nome de uma pessoa.
	 * @param id   int Recebe o ID de uma pessoa.
	 */

	public Pessoa(String cpf, String nome, int id) {
		this.cpf = cpf;
		this.nome = nome;
		this.id = id;

	}

	/**
	 * Metodo responsavel por somar uma noma despesa a despesa anterior.
	 * 
	 * @param valor_despesa double Recebe o valor da despesa a ser somado.
	 */

	public void somarTotalDespesa(double valor_despesa) {

		this.totalDespesa = this.totalDespesa + valor_despesa;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public double getTotalDespesa() {
		return totalDespesa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
