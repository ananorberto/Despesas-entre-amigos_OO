package model;

/**
 * Classe Compra cadastra os dados de uma compra e herda da classe Despesa.
 * 
 * @author Leonardo, Ana Beatriz
 * @since 2022
 * @version 1.0
 *
 */
public class Compra extends Despesa {

	private String itens;
	private String nomeMercado;

	/**
	 * Construtor responsavel por cadastrar o nome, valor, data, os itens de uma
	 * compra vinculados a uma pessoa e um grupo.
	 * 
	 * 
	 * @param nome_mercado String Recebera o nome do mercado que o usuario colocar.
	 * @param valor        double Recebe o valor da compra.
	 * @param data         String Recebe a data em que a pessoa fez a compra.
	 * @param cpfPagador   int Localiza o CPF da pessoa que fez a compra.
	 * @param nomeGrupoInt String Localiza o grupo no qual a compra sera cadastrada.
	 * @param itens        String Recebe os itens que a pessoa comprou.
	 */

	public Compra(String nome_mercado, double valor, String data, int cpfPagador, String nomeGrupo, String itens) {
		this.nomeMercado = nome_mercado;
		this.valor = valor;
		this.data = data;
		this.cpfPagador = cpfPagador;
		this.nomeGrupo = nomeGrupo;
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
