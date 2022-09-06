package model;

/**
 * Classe Imovel cadastra os dados de um imovel e herda da classe Despesa.
 * 
 * @author Ana Beatriz, Leonardo
 * @since 2022
 * @version 1.0
 *
 */
public class Imovel extends Despesa {

	private String endereco;
	private double valorContaLuz;
	private double valorContaAgua;
	private double aluguel;

	/**
	 * Construtor responsavel por cadastrar o endereco, valor da conta de luz, valor
	 * da conta de agua, valor do aluguel, data do pagamento vinculado a uma pessoa
	 * e um grupo.
	 * 
	 * 
	 * @param endereco       String Recebe o endereço do imovel.
	 * @param valorContaLuz  double Recebe o valor da conta de luz.
	 * @param valorContaAgua double Recebe o valor da conta de agua.
	 * @param aluguel        double Recebe o valor do aluguel.
	 * @param data           String Recebe a data em que a pessoa fez o pagamento.
	 * @param idPagador      int Localiza o ID da pessoa que fez o pagamento.
	 * @param idGrupo        int Localiza o grupo no qual os gastos serao
	 *                       cadastrados.
	 */

	public Imovel(String endereco, double valorContaLuz, double valorContaAgua, double aluguel, String data,
			int idPagador, int idGrupo) {
		this.endereco = endereco;
		this.valorContaLuz = valorContaLuz;
		this.valorContaAgua = valorContaAgua;
		this.aluguel = aluguel;
		this.data = data;
		this.idPagador = idPagador;
		this.idGrupo = idGrupo;
	}

	/**
	 * Metodo responsavel por somar os valores da conta de agua, conta de luz e
	 * aluguel.
	 */

	public void somar_gastos() {
		this.valor = this.valorContaAgua + this.valorContaLuz + this.aluguel;
	}

}
