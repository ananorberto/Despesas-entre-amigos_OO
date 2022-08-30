package model;
public class Compra extends Despesa {

	private String itens;
	private String nome_mercado;

	public Compra(String nome_mercado, double valor, String data, int id_pagador, int id_grupo, String itens) {
		this.nome_mercado = nome_mercado;
		this.valor = valor;
		this.data = data;
		this.id_pagador = id_pagador;
		this.id_grupo = id_grupo;
		this.itens = itens;
	}

	public String getItens() {
		return itens;
	}

	public void setItens(String itens) {
		this.itens = itens;
	}

	public String getNome_mercado() {
		return nome_mercado;
	}

	public void setNome_mercado(String nome_mercado) {
		this.nome_mercado = nome_mercado;
	}
	
	
	
}
