package model;
public abstract class Despesa {

	protected double valor;
	protected String data;
	protected int id_pagador;
	protected int id_grupo;


	public int getId_pagador() {
		return id_pagador;
	}



	public void setId_pagador(int id_pagador) {
		this.id_pagador = id_pagador;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public double getValor() {
		return valor;
	}
}
