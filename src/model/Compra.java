package model;
public class Compra extends Despesa {

	private String itens;
	private String nomeMercado;

	public Compra(String nome_mercado, double valor, String data, int id_pagador, int id_grupo, String itens) {
		this.nomeMercado = nome_mercado;
		this.valor = valor;
		this.data = data;
		this.idPagador = id_pagador;
		this.idGrupo = id_grupo;
		this.itens = itens;
	}

	public String getItens() {
		return itens;
	}

	public void setItens(String itens) {
		this.itens = itens;
	}

	public String getNomeMercado() {
		return nomeMercado;
	}

	public void setNome_mercado(String nomeMercado) {
		this.nomeMercado = nomeMercado;
	}
	
	
	
}
