package model;
public class Imovel extends Despesa {

	private String endereco;
	private double valor_conta_luz;
	private double valor_conta_agua;
	private double aluguel;

	public Imovel(String endereco, double valor_conta_luz, double valor_conta_agua, double aluguel, String data, int id_pagador, int id_grupo) {
		this.endereco = endereco;
		this.valor_conta_luz = valor_conta_luz;
		this.valor_conta_agua = valor_conta_agua;
		this.aluguel = aluguel;
		this.data = data;
		this.id_pagador = id_pagador;
		this.id_grupo = id_grupo;
	}

	public void somar_gastos() {
		this.valor = this.valor_conta_agua + this.valor_conta_luz + this.aluguel;
	}

}
