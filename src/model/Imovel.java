package model;

public class Imovel extends Despesa {

	private String endereco;
	private double valorContaLuz;
	private double valorContaAgua;
	private double aluguel;

	public Imovel(String endereco, double valorContaLuz, double valorContaAgua, double aluguel, 
				  String data, int idPagador, int idGrupo) {
		this.endereco = endereco;
		this.valorContaLuz = valorContaLuz;
		this.valorContaAgua = valorContaAgua;
		this.aluguel = aluguel;
		this.data = data;
		this.idPagador = idPagador;
		this.idGrupo = idGrupo;
	}

	public void somar_gastos() {
		this.valor = this.valorContaAgua + this.valorContaLuz + this.aluguel;
	}

}
