package model;

public class Pessoa {

	private String cpf;
	private String nome;
	private int id;
	private double total_despesa = 0;
	private double saldo;

	public Pessoa(String cpf, String nome, int id) {
		this.cpf = cpf;
		this.nome = nome;
		this.id = id;

	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public double getTotal_despesa() {
		return total_despesa;
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

	public void setTotal_despesa(double valor_despesa) {

		this.total_despesa = this.total_despesa + valor_despesa;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String mostrar_dados() {
		return ("CPF: " + cpf +
				"\nNOME: " + nome +
				"\nID: " + id);
	}


}
