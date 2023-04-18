package controller;

import javax.swing.JOptionPane;

import database.Database;
import model.Pessoa;

/**
 * Classe responsavel por cadastrar uma pessoa
 * 
 * @author Leonardo
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
	 * 
	 * @return resultado boolean retorna false se o cadastro não foi efetuado, e
	 *         true caso tenha sido efetuado com sucesso.
	 */
	public static boolean cadastrarPessoa(String nomeString, String idPessoaString, String cpfString,
			String nomeGrupoString) {
		boolean resultado = false;
		try {
			boolean naoRepete = true;
			boolean grupoCheio;
			boolean cpfCerto = false;
			int idPessoaInt = Integer.parseInt(idPessoaString);

			// Verifica se o cpf tem apenas numeros e exatamente 11 digitos
			if (cpfString.matches("^[0-9]*$") && cpfString.length() == 11) {
				cpfCerto = true;
			}

			// Verifica se há repeticao de id ou cpf de pessoa
			for (int j = 0; j < Database.getQtdeGrupos(); j++) {
				if (Database.getGrupos().get(j).getQtdePessoas() == 0) {
					continue;
				}
				if (nomeGrupoString.equals(Database.getGrupos().get(j).getNome())) {
					for (int k = 0; k < Database.getGrupos().get(j).getQtdePessoas(); k++) {
						if (cpfString.equals(Database.getGrupos().get(j).getPessoas().get(k).getCpf())
								|| (Database.getGrupos().get(j).getPessoas().get(k).getId() == idPessoaInt)) {

							naoRepete = false;

							break;
						}
					}
				}

				if (naoRepete == false) {
					break;
				}
			}
			if (naoRepete == true && cpfCerto == true) {
				// se o cpf eta certo e nao há repeticao de id ou cpf, executa o for abaixo
				for (int i = 0; i < Database.getQtdeGrupos(); i++) {
					if (nomeGrupoString.equals(Database.getGrupos().get(i).getNome())) {
						// Encontrou o grupo
						// Cadastra a pessoa
						Pessoa novaPessoa = new Pessoa(cpfString, nomeString, idPessoaInt);

						Database.getGrupos().get(i).setNovaPessoa(novaPessoa);
						// Retorna true se o grupo esta cheio
						grupoCheio = Database.getGrupos().get(i).addPessoa();

						if (grupoCheio == false) {
							// Se o grupo nao esta cheio o cadastro foi feito
							JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro",
									JOptionPane.PLAIN_MESSAGE);
							resultado = true;
						}

						break;
					} else if (i == (Database.getQtdeGrupos() - 1)) {
						JOptionPane.showMessageDialog(null, "Nao encontramos um grupo com o nome inserido", "Erro",
								JOptionPane.PLAIN_MESSAGE);

					}
				}
			} else if (cpfCerto == false) {
				JOptionPane.showMessageDialog(null, "O CPF inserido não é válido", "Erro", JOptionPane.PLAIN_MESSAGE);

			}

			else {
				JOptionPane.showMessageDialog(null, "Ja existe um usuario com esse CPF ou ID nesse grupo", "Erro",
						JOptionPane.PLAIN_MESSAGE);

			}

		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "o ID deve conter apenas numeros", "Erro", JOptionPane.PLAIN_MESSAGE);

		}

		return resultado;
	}

}
