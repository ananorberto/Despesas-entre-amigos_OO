package controller;

import javax.swing.JOptionPane;

import database.Database;
import model.Compra;
import model.Imovel;

public class ControleDespesa {

	public ControleDespesa() {
	}

	/**
	 * Metodo responsavel por cadastrar uma despesa do tipo compra em um grupo.
	 * 
	 * @param nomeMercadoString String Recebe nome do mercado.
	 * @param cpfPagadorString  String Recebe o CPF do pagador.
	 * @param nomeGrupoString   String Recebe o Nome do grupo.
	 * @param itensString       String Recebe os itens da compra
	 * @param valorString       String Recebe o valor da compra.
	 * @param dataString        String Recebe a data da compra.
	 */
	public static void cadastrarCompra(String nomeMercadoString, String cpfPagadorString, String nomeGrupoString,
			String itensString, String valorString, String dataString) {
		try {
			boolean acabou = false;

			double valorDouble = Double.parseDouble(valorString);

			for (int i = 0; i < Database.getQtdeGrupos(); i++) {
				if (nomeGrupoString.equals(Database.getGrupos().get(i).getNome())) {
					// Achou o grupo
					for (int j = 0; j < Database.getGrupos().get(i).getQtdePessoas(); j++) {
						if (cpfPagadorString.equals(Database.getGrupos().get(i).getPessoas().get(j).getCpf())) {
							// Achou a pessoa
							acabou = true;
							Compra novaCompra = new Compra(nomeMercadoString, valorDouble, dataString, cpfPagadorString,
									nomeGrupoString, itensString);
							Database.getGrupos().get(i).getDespesas().add(novaCompra);
							Database.getGrupos().get(i).aumentarQtdeDespesas();
							Database.getGrupos().get(i).getPessoas().get(j).somarTotalDespesa(valorDouble);

							JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro",
									JOptionPane.PLAIN_MESSAGE);

							break;
						} else if (j == (Database.getGrupos().get(i).getQtdeDespesas() - 1)) {
							// Nao achou a pessoa
							JOptionPane.showMessageDialog(null,
									"Nao encontramos uma pessoa ou um grupo com os IDs inseridos",
									"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
							acabou = true;

						}

					}
					if (acabou == true) {
						// Parar de procurar os grupos assim que encontrar a pessoa
						break;
					}

				} else if (i == (Database.getQtdeGrupos() - 1)) {
					// Nao achou o grupo
					JOptionPane.showMessageDialog(null, "Nao encontramos uma pessoa ou grupo com o ID inserido",
							"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);

				}
			}

		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro", JOptionPane.PLAIN_MESSAGE);

		}

	}

	/**
	 * Metodo responsavel por cadastrar uma despesa do tipo imovel em um grupo.
	 * 
	 * @param enderecoString   String Recebe o endereço do imovel.
	 * @param contaLuzString   String Recebe o valor da conta de luz.
	 * @param contaAguaString  String Recebe o valor da conta de agua.
	 * @param aluguelString    String Recebe o valor do aluguel.
	 * @param dataString       String Recebe a data em que a pessoa fez o pagamento.
	 * @param cpfPagadorString String Recebe o CPF da pessoa que pagou a despesa.
	 * @param nomeGrupoString  String Recebe o Nome do grupo que sera cadastrada a
	 *                         despesa.
	 */

	public static void cadastrarImovel(String enderecoString, String contaLuzString, String contaAguaString,
			String aluguelString, String dataString, String cpfPagadorString, String nomeGrupoString) {

		try {
			boolean acabou = false;
			double contaLuzDouble = Double.parseDouble(contaLuzString);
			double contaAguaDouble = Double.parseDouble(contaAguaString);
			double aluguelDouble = Double.parseDouble(aluguelString);

			for (int i = 0; i < Database.getQtdeGrupos(); i++) {
				if (nomeGrupoString.equals(Database.getGrupos().get(i).getNome())) {
					// Achou o grupo
					for (int j = 0; j < Database.getGrupos().get(i).getQtdePessoas(); j++) {
						if (cpfPagadorString.equals(Database.getGrupos().get(i).getPessoas().get(j).getCpf())) {
							// Achou a pessoa
							acabou = true;
							Imovel novoImovel = new Imovel(enderecoString, contaLuzDouble, contaAguaDouble,
									aluguelDouble, dataString, cpfPagadorString, nomeGrupoString);

							novoImovel.somar_gastos();

							Database.getGrupos().get(i).getDespesas().add(novoImovel);
							Database.getGrupos().get(i).aumentarQtdeDespesas();
							Database.getGrupos().get(i).getPessoas().get(j).somarTotalDespesa(novoImovel.getValor());

							JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro",
									JOptionPane.PLAIN_MESSAGE);

							break;

						} else if (j == (Database.getGrupos().get(i).getQtdePessoas() - 1)) {
							// Nao achou a pessoa
							JOptionPane.showMessageDialog(null,
									"Nao encontramos uma pessoa ou um grupo com os IDs inseridos",
									"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
							acabou = true;

							break;
						}

					}
					if (acabou == true) {
						// Parar de procurar os grupos assim que encontrar a pessoa
						break;
					}

				} else if (i == (Database.getQtdeGrupos() - 1)) {
					// Nao achou o grupo
					JOptionPane.showMessageDialog(null, "Nao encontramos uma pessoa ou um grupo com os IDs inseridos",
							"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
				}
			}

		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
