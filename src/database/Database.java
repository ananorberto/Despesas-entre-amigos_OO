package database;

import java.util.ArrayList;
import java.util.List;

import model.Compra;
import model.Grupo;
import model.Imovel;
import model.Pessoa;

/**
 * Classe Database é responsavel por armazenar dados a ser cadastrados e
 * pre-cadastrados.
 * 
 * @author Leonardo, Ana Beatriz
 * @since 2022
 * @version 1.0
 * @see ArrayList
 *
 */
public class Database {
	private static final List<Grupo> GRUPOS = new ArrayList<Grupo>();
	private static int qtdeGrupos = 0;

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

	public static int getQtdeGrupos() {
		return qtdeGrupos;
	}

	public static void setQtdeGrupos(int num) {
		qtdeGrupos = num;
	}

	/**
	 * Metodo responsavel por diminuir a quantidade de grupos.
	 */
	public static void diminuirQtdeGrupos() {
		qtdeGrupos = qtdeGrupos - 1;
	}

	/**
	 * Metodo responsavel por aumentar a quantidade de grupos.
	 */
	public static void aumentarQtdeGrupos() {
		qtdeGrupos = qtdeGrupos + 1;
	}

	public static List<Grupo> getGrupos() {
		return GRUPOS;
	}

	/**
	 * Metodo responsavel por armazenar grupos pre-cadastrados.
	 */
	public static void preCadastrarGrupos() {
		GRUPOS.add(g1);
		GRUPOS.add(g2);
		GRUPOS.add(g3);

		GRUPOS.get(0).setNovaPessoa(p1_1);
		GRUPOS.get(0).addPessoa();
		GRUPOS.get(0).setNovaPessoa(p1_2);
		GRUPOS.get(0).addPessoa();

		GRUPOS.get(1).setNovaPessoa(p2_1);
		GRUPOS.get(1).addPessoa();
		GRUPOS.get(1).setNovaPessoa(p2_2);
		GRUPOS.get(1).addPessoa();

		GRUPOS.get(2).setNovaPessoa(p3_1);
		GRUPOS.get(2).addPessoa();
		GRUPOS.get(2).setNovaPessoa(p3_2);
		GRUPOS.get(2).addPessoa();

		GRUPOS.get(0).getDespesas().add(c1);
		GRUPOS.get(0).getPessoas().get(0).somarTotalDespesa(c1.getValor());
		GRUPOS.get(0).aumentarQtdeDespesas();
		i1.somar_gastos();
		GRUPOS.get(0).getDespesas().add(i1);
		GRUPOS.get(0).getPessoas().get(1).somarTotalDespesa(i1.getValor());
		GRUPOS.get(0).aumentarQtdeDespesas();

		GRUPOS.get(1).getDespesas().add(c2);
		GRUPOS.get(1).getPessoas().get(0).somarTotalDespesa(c2.getValor());
		GRUPOS.get(1).aumentarQtdeDespesas();
		i2.somar_gastos();
		GRUPOS.get(1).getDespesas().add(i2);
		GRUPOS.get(1).getPessoas().get(1).somarTotalDespesa(i2.getValor());
		GRUPOS.get(1).aumentarQtdeDespesas();

		GRUPOS.get(2).getDespesas().add(c3);
		GRUPOS.get(2).getPessoas().get(0).somarTotalDespesa(c3.getValor());
		GRUPOS.get(2).aumentarQtdeDespesas();
		i3.somar_gastos();
		GRUPOS.get(2).getDespesas().add(i3);
		GRUPOS.get(2).getPessoas().get(1).somarTotalDespesa(i3.getValor());
		GRUPOS.get(2).aumentarQtdeDespesas();

		qtdeGrupos = 3;
	}

}
