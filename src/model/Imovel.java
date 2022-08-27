package model;
public class Imovel extends Despesa {

	private String tipo_imovel;
	private String endereco;
	private double valor_conta_luz;
	private double valor_conta_agua;
	private double aluguel;

	public Imovel(String tipo_imovel, String endereco, double valor_conta_luz, double valor_conta_agua, double aluguel, String data, int id_pagador) {
		this.tipo_imovel = tipo_imovel;
		this.endereco = endereco;
		this.valor_conta_luz = valor_conta_luz;
		this.valor_conta_agua = valor_conta_agua;
		this.aluguel = aluguel;
		this.data = data;
		this.id_pagador = id_pagador;
	}

	public void somar_gastos() {
		this.valor = this.valor_conta_agua + this.valor_conta_luz + this.aluguel;
	}

}
