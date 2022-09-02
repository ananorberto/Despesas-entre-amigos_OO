package model.model_database;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class Database {
	private static final List<Grupo> GRUPOS = new ArrayList<Grupo>();
	private static int qtde_grupos = 0;
	
	private static Grupo g1 = new Grupo(3, 100, "grupo1");
	private static Grupo g2 = new Grupo(3, 101, "grupo2");
	private static Grupo g3 = new Grupo(3, 102, "grupo3");
	
	private static Pessoa p1_1 = new Pessoa("00000000000", "Joao", 111);
	private static Pessoa p1_2 = new Pessoa("11111111111", "Jose", 222);
	private static Pessoa p2_1 = new Pessoa("22222222222", "Maria", 333);
	private static Pessoa p2_2 = new Pessoa("33333333333", "Ana", 444);
	private static Pessoa p3_1 = new Pessoa("44444444444", "Luiza", 555);
	private static Pessoa p3_2 = new Pessoa("55555555555", "Pedro", 666);
	
	private static Compra c1 = new Compra("Atacadao da massa", 50.30, "15/02/2022", 111, 100, "pao, ovo");
	private static Compra c2 = new Compra("Atacadao da massa", 50.30, "15/02/2022", 333, 101, "pao, ovo");
	private static Compra c3 = new Compra("Atacadao da massa", 50.30, "15/02/2022", 555, 102, "pao, ovo");
	
	private static Imovel i1 = new Imovel("Brasilia", 15.30, 25.80, 32.40, "03/03/2022", 222, 100);
	private static Imovel i2 = new Imovel("Brasilia", 15.30, 25.80, 32.40, "03/03/2022", 444, 101);
	private static Imovel i3 = new Imovel("Brasilia", 15.30, 25.80, 32.40, "03/03/2022", 666, 102);

	public Database() {
	}

	public static int getQtde_grupos() {
		return qtde_grupos;
	}
	
	public static void diminuir_Qtde_grupos() {
		qtde_grupos = qtde_grupos -1;
	}


	public static void aumentar_contador_grupos() {
		qtde_grupos = qtde_grupos + 1;
	}

	public static List<Grupo> getGrupos() {
		return GRUPOS;
	}

	public static void pre_cadastrar_grupos() {
		GRUPOS.add(g1);
		GRUPOS.add(g2);
		GRUPOS.add(g3);
		
		GRUPOS.get(0).setNova_pessoa(p1_1);
		GRUPOS.get(0).add_pessoa();
		GRUPOS.get(0).setNova_pessoa(p1_2);
		GRUPOS.get(0).add_pessoa();
		
		GRUPOS.get(1).setNova_pessoa(p2_1);
		GRUPOS.get(1).add_pessoa();
		GRUPOS.get(1).setNova_pessoa(p2_2);
		GRUPOS.get(1).add_pessoa();
		
		GRUPOS.get(2).setNova_pessoa(p3_1);
		GRUPOS.get(2).add_pessoa();
		GRUPOS.get(2).setNova_pessoa(p3_2);
		GRUPOS.get(2).add_pessoa();
		
		GRUPOS.get(0).getDespesas().add(c1);
		GRUPOS.get(0).getPessoas().get(0).setTotal_despesa(c1.getValor());
		GRUPOS.get(0).aumentar_qtde_despesas();
		i1.somar_gastos();
		GRUPOS.get(0).getDespesas().add(i1);
		GRUPOS.get(0).getPessoas().get(1).setTotal_despesa(i1.getValor());
		GRUPOS.get(0).aumentar_qtde_despesas();
		
		GRUPOS.get(1).getDespesas().add(c2);
		GRUPOS.get(1).getPessoas().get(0).setTotal_despesa(c2.getValor());
		GRUPOS.get(1).aumentar_qtde_despesas();
		i2.somar_gastos();
		GRUPOS.get(1).getDespesas().add(i2);
		GRUPOS.get(1).getPessoas().get(1).setTotal_despesa(i2.getValor());
		GRUPOS.get(1).aumentar_qtde_despesas();
		
		GRUPOS.get(2).getDespesas().add(c3);
		GRUPOS.get(2).getPessoas().get(0).setTotal_despesa(c3.getValor());
		GRUPOS.get(2).aumentar_qtde_despesas();
		i3.somar_gastos();
		GRUPOS.get(2).getDespesas().add(i3);
		GRUPOS.get(2).getPessoas().get(1).setTotal_despesa(i3.getValor());
		GRUPOS.get(2).aumentar_qtde_despesas();

		
		qtde_grupos = 3;
	}

}
