package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import static java.lang.Math.abs;
import static java.lang.String.format;

public class Grupo {

	private String nome;
	private int id;
	private int max_pessoas;
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Pessoa nova_pessoa;
	private ArrayList<Despesa> despesas = new ArrayList<Despesa>();
	private double despesa_dividida;
	int qtde_pessoas = 0;
	int qtde_despesas = 0;

	public Grupo(int max_pessoas, int id, String nome) {
		this.max_pessoas = max_pessoas;
		this.nome = nome;
		this.id = id;
	}

	public void diminuir_qtde_pessoas() {
		this.qtde_pessoas = this.qtde_pessoas - 1;
	}
	
	public int getQtde_despesas() {

		return qtde_despesas;
	}

	public void aumentar_qtde_despesas() {

		this.qtde_despesas++;
	}

	public int getQtde_pessoas() {

		return qtde_pessoas;
	}

	public void setQtde_pessoas(int qtde_pessoas) {

		this.qtde_pessoas = qtde_pessoas;
	}

	public ArrayList<Pessoa> getPessoas() {

		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {

		this.pessoas = pessoas;
	}

	public ArrayList<Despesa> getDespesas() {

		return despesas;
	}

	public void setDespesas(ArrayList<Despesa> despesas) {

		this.despesas = despesas;
	}

	public Pessoa getNova_pessoa() {

		return nova_pessoa;
	}

	public void setNova_pessoa(Pessoa nova_pessoa) {

		this.nova_pessoa = nova_pessoa;
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

	public void setMax_pessoas(int max_pessoas) {
		this.max_pessoas = max_pessoas;
	}

	public boolean add_pessoa() {
		if (qtde_pessoas < max_pessoas) {

			pessoas.add(this.nova_pessoa);
			qtde_pessoas++;
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "O grupo escolhido está cheio", 
						"Erro", JOptionPane.PLAIN_MESSAGE);
			return true;
		}

	}

	public void definir_saldos() {
		for (int i = 0; i < qtde_pessoas; i++) {
			pessoas.get(i).setSaldo(pessoas.get(i).getTotal_despesa() - this.despesa_dividida);
		}
	}

	public void dividir_despesas() {
		this.despesa_dividida = 0.0;
		
		for (int i = 0; i < qtde_pessoas; i++) {
			this.despesa_dividida = this.despesa_dividida + pessoas.get(i).getTotal_despesa();
		}

		this.despesa_dividida = (this.despesa_dividida) / qtde_pessoas;

	}

	public String[] mostrar_dividas() {
		String dividas[] = new String[qtde_pessoas];
		int j = 0;
		for (int i = 0; i < qtde_pessoas; i++) {
			if (pessoas.get(i).getSaldo() < 0) {
				dividas[j] = (pessoas.get(i).getNome() + " deve ao grupo" + "R$" + format("%.2f", abs(pessoas.get(i).getSaldo())));
				j++;
			} else {
				dividas[j] = ("O grupo deve " + pessoas.get(i).getNome() + " R$" + format("%.2f", abs(pessoas.get(i).getSaldo())));
				j++;
			}
		}

		return dividas;
	}

}
