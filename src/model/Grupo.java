package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import static java.lang.Math.abs;
import static java.lang.String.format;

public class Grupo {

	private String nome;
	private int id;
	private int maxPessoas;
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Pessoa novaPessoa;
	private ArrayList<Despesa> despesas = new ArrayList<Despesa>();
	private double despesaDividida;
	int qtdePessoas = 0;
	int qtdeDespesas = 0;

	public Grupo(int maxPessoas, int id, String nome) {
		this.maxPessoas = maxPessoas;
		this.nome = nome;
		this.id = id;
	}

	
	
	public double getDespesaDividida() {
		return despesaDividida;
	}



	public void setDespesaDividida(double despesaDividida) {
		this.despesaDividida = despesaDividida;
	}



	public void diminuirQtdePessoas() {
		this.qtdePessoas = this.qtdePessoas - 1;
	}
	
	public int getQtdeDespesas() {

		return qtdeDespesas;
	}

	public void aumentarQtdeDespesas() {

		this.qtdeDespesas++;
	}

	public int getQtdePessoas() {

		return qtdePessoas;
	}

	public void setQtdePessoas(int qtdePessoas) {

		this.qtdePessoas = qtdePessoas;
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

	public Pessoa getNovaPessoa() {

		return novaPessoa;
	}

	public void setNovaPessoa(Pessoa novaPessoa) {

		this.novaPessoa = novaPessoa;
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

	public int getMaxPessoas() {

		return maxPessoas;
	}

	public void setMaxPessoas(int maxPessoas) {
		this.maxPessoas = maxPessoas;
	}

	public boolean addPessoa() {
		if (qtdePessoas < maxPessoas) {

			pessoas.add(this.novaPessoa);
			qtdePessoas++;
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "O grupo escolhido está cheio", 
						"Erro", JOptionPane.PLAIN_MESSAGE);
			return true;
		}

	}

	public void definirSaldos() {
		for (int i = 0; i < qtdePessoas; i++) {
			pessoas.get(i).setSaldo(pessoas.get(i).getTotalDespesa() - this.despesaDividida);
		}
	}

	public void dividirDespesas() {
		this.despesaDividida = 0.0;
		
		for (int i = 0; i < qtdePessoas; i++) {
			this.despesaDividida = this.despesaDividida + pessoas.get(i).getTotalDespesa();
		}

		this.despesaDividida = (this.despesaDividida) / qtdePessoas;

	}

	public String[] mostrarDividas() {
		String dividas[] = new String[qtdePessoas + 1];
		dividas[0] = ("A despesa dividida é de R$ " + format("%.2f" , this.despesaDividida));
		int j = 1;
		for (int i = 0; i < qtdePessoas; i++) {
			if (pessoas.get(i).getSaldo() < 0) {
				dividas[j] = (pessoas.get(i).getNome() + " deve ao grupo " + "R$ " + format("%.2f", abs(pessoas.get(i).getSaldo())));
				j++;
			} else {
				dividas[j] = ("O grupo deve " + pessoas.get(i).getNome() + " R$ " + format("%.2f", abs(pessoas.get(i).getSaldo())));
				j++;
			}
		}

		return dividas;
	}

}
