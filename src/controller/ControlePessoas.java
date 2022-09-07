package controller;

import javax.swing.JOptionPane;

import database.Database;
import model.Pessoa;

/**
 * Classe responsavel por cadastrar uma pessoa
 * 
 * @author Leonardo,
 * @since 2022
 * @version 1.0
 */
public class ControlePessoas {

	public ControlePessoas() {
	}

	/**
	 * Metodo responsavel por pegar os nomes das pessoas cadastradas em determinado
	 * grupo.
	 * 
	 * @param pos int Seleciona determinada posição.
	 * @return String[] Retorna lista de nomes do grupo.
	 */

	public static String[] pegarNomePessoas(int pos) {
		String nomesPessoa[] = new String[Database.getGrupos().get(pos).getQtdePessoas()];
		for (int i = 0; i < Database.getGrupos().get(pos).getQtdePessoas(); i++) {
			nomesPessoa[i] = Database.getGrupos().get(pos).getPessoas().get(i).getNome();
		}
		return nomesPessoa;
	}

	/**
	 * Metodo responsavel por cadastrar uma pessoa no grupo, verificar se o ID
	 * inserido repete e/ou existe ou nao.
	 * 
	 * @param nomeString      String Cadastra o nome de uma pessoa.
	 * @param idPessoaString  String Cadastra o ID de uma pessoa.
	 * @param cpfString       String Cadastra o CPF de uma pessoa
	 * @param nomeGrupoString String Cadastra pessoa no grupo.
	 */
	public static void cadastrarPessoa(String nomeString, String idPessoaString, String cpfString,
			String nomeGrupoString) {
		try {
			boolean naoRepete = true;
			boolean grupoCheio;
			int idPessoaInt = Integer.parseInt(idPessoaString);
			int cpfInt = Integer.parseInt(cpfString);

			// Repeticao de id de usuario
			for (int j = 0; j < Database.getQtdeGrupos(); j++) {
				if (Database.getGrupos().get(j).getQtdePessoas() == 0) {
					continue;
				}

				for (int k = 0; k < Database.getGrupos().get(j).getQtdePessoas(); k++) {
					if (nomeGrupoString.equals(Database.getGrupos().get(j).getPessoas().get(k).getNome())) {
						naoRepete = false;
						break;
					}
				}
				if (naoRepete == false) {
					break;
				}
			}

			if (naoRepete == true) {
				for (int i = 0; i < Database.getQtdeGrupos(); i++) {
					if (nomeGrupoString.equals(Database.getGrupos().get(i).getNome())) {
						Pessoa novaPessoa = new Pessoa(cpfInt, nomeString, idPessoaInt);

						Database.getGrupos().get(i).setNovaPessoa(novaPessoa);
						grupoCheio = Database.getGrupos().get(i).addPessoa();

						if (grupoCheio == false) {
							JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro",
									JOptionPane.PLAIN_MESSAGE);
						}

						break;
					} else if (i == (Database.getQtdeGrupos() - 1)) {
						JOptionPane.showMessageDialog(null, "Nao encontramos um grupo com o ID inserido",
								"Grupo nao encontrado", JOptionPane.PLAIN_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ja existe um usuario com esse ID", "ID repetido",
						JOptionPane.PLAIN_MESSAGE);
			}

		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "O CPF e o ID devem conter apenas numeros", "Erro",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

}
