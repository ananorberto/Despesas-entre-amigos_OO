package model;
public class Compras extends Despesa {

	private String itens[] = new String[1000];
	private String nome_mercado;
	private String novo_item;
	int j = 0;

	public Compras(String nome_mercado, double valor, String data, int id_pagador) {
		this.nome_mercado = nome_mercado;
		this.valor = valor;
		this.data = data;
		this.id_pagador = id_pagador;
	}

	public void add_item() {
		itens[j] = novo_item;
		j++;
	}

}
