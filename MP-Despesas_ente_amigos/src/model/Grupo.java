package model;

import static java.lang.Math.abs;
import static java.lang.String.format;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Classe Grupo responsavel por armazenar pessoas e despesas do grupo.
 * 
 * @author Ana Beatriz, Leonardo
 * @since 2022
 * @version 1.0
 * @see ArrayList
 *
 */

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

	/**
	 * Construtor da classe grupo responsavel por definir o nome, ID do grupo e o
	 * maximo de pessoas de um grupo.
	 * 
	 * @param maxPessoas int Recebe a quantidade maxima de pessoas no grupo.
	 * @param id         int Recebe o ID do grupo.
	 * @param nome       String Recebe o nome do grupo.
	 */

	public Grupo(int maxPessoas, int id, String nome) {
		this.maxPessoas = maxPessoas;
		this.nome = nome;
		this.id = id;
	}

	/**
	 * Metodo responsavel por diminuir a quantidade de pessoas do grupo.
	 */
	public void diminuirQtdePessoas() {
		this.qtdePessoas = this.qtdePessoas - 1;
	}

	/**
	 * Metodo responsavel por aumentar a quantidade de despesas do grupo.
	 */
	public void aumentarQtdeDespesas() {

		this.qtdeDespesas++;
	}

	/**
	 * Metodo responsavel por adicionar uma nova pessoa no grupo e verificar se a
	 * quantidade maxima de pessoas foi excedido.
	 * 
	 * @return Boolean que retorna TRUE caso o limite de pessoas no grupo seja
	 *         excedido e FALSE caso o limite nao seja excedido e adiciona uma nova
	 *         pessoa no grupo.
	 * 
	 */

	public boolean addPessoa() {
		if (qtdePessoas < maxPessoas) {

			pessoas.add(this.novaPessoa);
			qtdePessoas++;
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "O grupo escolhido está cheio", "Erro", JOptionPane.PLAIN_MESSAGE);
			return true;
		}

	}

	/**
	 * Metodo responsavel por definir os saldos atuais das pessoas do grupo de
	 * acordo com a despesa.
	 */
	public void definirSaldos() {
		for (int i = 0; i < qtdePessoas; i++) {
			pessoas.get(i).setSaldo(pessoas.get(i).getTotalDespesa() - this.despesaDividida);
		}
	}

	/**
	 * Metodo responsavel por dividir as despesas do grupo pela quantidade de
	 * pessoas cadastradas nele.
	 */

	public void dividirDespesas() {
		this.despesaDividida = 0.0;

		for (int i = 0; i < qtdePessoas; i++) {
			// Soma o gasto de todas as pessoas do grupo
			this.despesaDividida = this.despesaDividida + pessoas.get(i).getTotalDespesa();
		}
		// Divide a despesa somada pela quantidade de pessoas
		this.despesaDividida = (this.despesaDividida) / qtdePessoas;

	}

	/**
	 * Metodo responsavel por mostrar a despesa dividida e as dividas de um grupo.
	 * 
	 * @return String[] que retorna as dividas do grupo e a despesa dividida.
	 */

	public String[] mostrarDividas() {
		String dividas[] = new String[qtdePessoas + 1];
		// Define que a primeira posicao do vetor informa a despesa dividida
		dividas[0] = ("A despesa dividida é de R$ " + format("%.2f", this.despesaDividida));
		int j = 1;
		for (int i = 0; i < qtdePessoas; i++) {
			if (pessoas.get(i).getSaldo() < 0) {
				// Se o saldo for negativo, a pessoa deve o grupo
				dividas[j] = (pessoas.get(i).getNome() + " deve ao grupo " + "R$ "
						+ format("%.2f", abs(pessoas.get(i).getSaldo())));
				j++;
			} else {
				// Se o saldo for positivo, o grupo deve essa pessoa
				dividas[j] = ("O grupo deve " + pessoas.get(i).getNome() + " R$ "
						+ format("%.2f", abs(pessoas.get(i).getSaldo())));
				j++;
			}
		}

		return dividas;
	}

	public double getDespesaDividida() {
		return despesaDividida;
	}

	public void setDespesaDividida(double despesaDividida) {
		this.despesaDividida = despesaDividida;
	}

	public int getQtdeDespesas() {

		return qtdeDespesas;
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

}
