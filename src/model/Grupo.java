package model;

import java.util.Scanner;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Grupo {
	Scanner scan = new Scanner(System.in);

	private String nome;
	private int id;
	private int max_pessoas;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario novo_usuario;
	private ArrayList<Despesa> despesas = new ArrayList<Despesa>();
	private Compras nova_compra;
	private Imovel novo_imovel;
	private double despesa_dividida = 0.0;
	int qtde_pessoas = 0;
	int j = 0;

	public Grupo(int max_pessoas, int id, String nome) {
		this.max_pessoas = max_pessoas;
		this.nome = nome;
		this.id = id;
	}
	
	
	
	public int getQtde_pessoas() {
		return qtde_pessoas;
	}



	public void setQtde_pessoas(int qtde_pessoas) {
		this.qtde_pessoas = qtde_pessoas;
	}



	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	public ArrayList<Despesa> getDespesas() {
		return despesas;
	}



	public void setDespesas(ArrayList<Despesa> despesas) {
		this.despesas = despesas;
	}



	public Usuario getNovo_usuario() {
		return novo_usuario;
	}

	public void setNovo_usuario(Usuario novo_usuario) {
		this.novo_usuario = novo_usuario;
	}

	public Compras getNova_compra() {
		return nova_compra;
	}

	public void setNova_compra(Compras nova_compra) {
		this.nova_compra = nova_compra;
	}

	public Imovel getNovo_imovel() {
		return novo_imovel;
	}

	public void setNovo_imovel(Imovel novo_imovel) {
		this.novo_imovel = novo_imovel;
	}

	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getMax_pessoas() {
		return max_pessoas;
	}




	public void setMax_pessoas(int qtde_pessoas) {
		this.max_pessoas = qtde_pessoas;
	}




	public void add_usuario() {
		if(qtde_pessoas < max_pessoas){
			
			usuarios.add(this.novo_usuario);
			qtde_pessoas++;
		}
		else{
			System.out.println("Tá cheio");
		}

	}
	
	public void definir_saldos() {
		for(int i = 0; i < max_pessoas; i++) {
			usuarios.get(i).setSaldo(this.despesa_dividida);
		}
	}

	public void dividir_despesas() {
		for(int i = 0; i < max_pessoas; i++) {
			this.despesa_dividida =  this.despesa_dividida + usuarios.get(i).getTotal_despesa();
		}
		
		this.despesa_dividida = (this.despesa_dividida)/max_pessoas;
		
	}

	public String[] mostrar_dividas() {
		String dividas[] = new String[max_pessoas];
		int j = 0;
		for(int i = 0; i < max_pessoas; i++) {
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
		for(int i = 0; i < max_pessoas; i++) {
			if(nova_compra.getId_pagador() == usuarios.get(i).getId()) {
				usuarios.get(i).setTotal_despesa(nova_compra.getValor());
			}
		}
	}

	public void add_imovel(){
		despesas.add(novo_imovel);
		for(int i = 0; i < max_pessoas; i++) {
			if(novo_imovel.getId_pagador() == usuarios.get(i).getId()) {
				usuarios.get(i).setTotal_despesa(novo_imovel.getValor());
			}
		}
	}

}
