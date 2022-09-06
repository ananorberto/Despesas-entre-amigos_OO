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
	protected int idPagador;
	protected int idGrupo;

	public int getIdPagador() {
		return idPagador;
	}

	public void setIdPagador(int idPagador) {
		this.idPagador = idPagador;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
}
