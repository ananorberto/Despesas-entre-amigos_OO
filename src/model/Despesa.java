package model;

/**
 * Classe abstrata Despesa responsavel por receber os atributos basicos de uma
 * despesa.
 * 
 * @author Ana Beatriz, Leonardo
 * @since 2022
 * @version 1.0
 *
 */
public abstract class Despesa {

	protected double valor;
	protected String data;
	protected int cpfPagador;
	protected String nomeGrupo;

	public int getIdPagador() {
		return cpfPagador;
	}

	public void setIdPagador(int idPagador) {
		this.cpfPagador = idPagador;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
}
