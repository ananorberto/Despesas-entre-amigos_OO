package model;

public class Pessoa {

	private String cpf;
	private String nome;
	private int id;
	private double totalDespesa = 0;
	private double saldo;

	public Pessoa(String cpf, String nome, int id) {
		this.cpf = cpf;
		this.nome = nome;
		this.id = id;

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

	public void setTotalDespesa(double valor_despesa) {

		this.totalDespesa = this.totalDespesa + valor_despesa;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
