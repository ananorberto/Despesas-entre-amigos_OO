package model;

import java.util.Scanner;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Grupo {
	Scanner scan = new Scanner(System.in);

	private String nome;
	private int id;
	private int qtde_pessoas;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario novo_usuario;
	private ArrayList<Despesa> despesas = new ArrayList<Despesa>();
	private Compras nova_compra;
	private Imovel novo_imovel;
	private double despesa_dividida = 0.0;
	int i = 0;
	int j = 0;

	public Grupo(int qtde_pessoas, int id, String nome) {
		this.qtde_pessoas = qtde_pessoas;
		this.nome = nome;
		this.id = id;
	}

	public void add_usuario() {
		if(i < qtde_pessoas){
			
			usuarios.add(this.novo_usuario);
		}
		else{
			System.out.println("Tá cheio");
		}

	}
	
	public void definir_saldos() {
		for(int i = 0; i < qtde_pessoas; i++) {
			usuarios.get(i).setSaldo(this.despesa_dividida);
		}
	}

	public void dividir_despesas() {
		for(int i = 0; i < qtde_pessoas; i++) {
			this.despesa_dividida =  this.despesa_dividida + usuarios.get(i).getTotal_despesa();
		}
		
		this.despesa_dividida = (this.despesa_dividida)/qtde_pessoas;
		
	}

	public String[] mostrar_dividas() {
		String dividas[] = new String[qtde_pessoas];
		int j = 0;
		for(int i = 0; i < qtde_pessoas; i++) {
			if(usuarios.get(i).getSaldo() < 0) {
				dividas[j] = (usuarios.get(i).getNome() + "deve ao grupo" + "R$" + abs(usuarios.get(i).getSaldo()));
				j++;
			}
			else{
				dividas[j] = ("O grupo deve " + usuarios.get(i).getNome()  + "R$" + abs(usuarios.get(i).getSaldo()));
				j++;
			}
		}

		return dividas;
	}

	public void add_compras() {
		despesas.add(nova_compra);
		for(int i = 0; i < qtde_pessoas; i++) {
			if(nova_compra.getId_pagador() == usuarios.get(i).getId()) {
				usuarios.get(i).setTotal_despesa(nova_compra.getValor());
			}
		}
	}

	public void add_imovel(){
		despesas.add(novo_imovel);
		for(int i = 0; i < qtde_pessoas; i++) {
			if(novo_imovel.getId_pagador() == usuarios.get(i).getId()) {
				usuarios.get(i).setTotal_despesa(novo_imovel.getValor());
			}
		}
	}

}
