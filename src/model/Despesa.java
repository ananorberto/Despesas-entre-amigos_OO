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
	protected String cpfPagador;
	protected String nomeGrupo;

	public String getIdPagador() {
		return cpfPagador;
	}

	public void setIdPagador(String idPagador) {
		this.cpfPagador = idPagador;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
}
