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

	public Database() {
	}

	public static int getQtde_grupos() {
		return qtde_grupos;
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
		
		qtde_grupos = 3;
	}

}
