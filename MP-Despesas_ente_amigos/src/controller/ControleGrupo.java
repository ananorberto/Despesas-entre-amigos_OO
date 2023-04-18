package controller;

import javax.swing.JOptionPane;

import database.Database;
import model.Grupo;

/**
 * Classe responsavel por cadastrar um grupo.
 * 
 * @author Leonardo, Ana Beatriz
 * @since 2022
 * @version 1.0
 */
public class ControleGrupo {

	public ControleGrupo() {
	}

	/**
	 * Metodo responsavel por pegar os nomes dos grupos cadastrados.
	 * 
	 * @return String[] Retorna lista de nomes dos grupos.
	 */

	public static String[] pegarNomeGrupo() {

		String[] nomesGrupo = new String[Database.getQtdeGrupos()];
		for (int i = 0; i < Database.getQtdeGrupos(); i++) {
			nomesGrupo[i] = Database.getGrupos().get(i).getNome();
		}
		return nomesGrupo;
	}

	/**
	 * Metodo responsavel por cadastrar um grupo e verificar se ja existe um grupo
	 * com o mesmo ID.
	 * 
	 * @param nomeGrupoString String Retorna nome do grupo.
	 * @param idString        String Retorna ID do grupo.
	 * @param maxPessoas      String Retorna quantidade maxima de pessoas no grupo
	 * 
	 * @return resultado boolean Retorna false se houver erro na realização do
	 *         cadastro, e true se o cadastro for efetuado com sucesso.
	 */

	public static boolean cadastrarGrupo(String nomeGrupoString, String idString, String maxPessoasString) {
		boolean naoRepete = true;
		boolean resultado = false;

		try {
			int idInt = Integer.parseInt(idString);
			int maxPessoasInt = Integer.parseInt(maxPessoasString);

			for (int i = 0; i < Database.getQtdeGrupos(); i++) {
				if (nomeGrupoString.equals(Database.getGrupos().get(i).getNome())) {
					// Verifica se ha algum grupo com nome repetido
					naoRepete = false;
				} else if (Database.getGrupos().get(i).getId() == idInt) {
					naoRepete = false;
					break;
				}
			}

			if (naoRepete == true) {
				// se nao ha grupos cadastrados com esse nome, o cadastro ocorre
				Grupo novoGrupo = new Grupo(maxPessoasInt, idInt, nomeGrupoString);

				Database.getGrupos().add(novoGrupo);
				Database.aumentarQtdeGrupos();

				JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro",
						JOptionPane.PLAIN_MESSAGE);
				resultado = true;

			} else {
				JOptionPane.showMessageDialog(null, "Ja existe um grupo com esse Nome ou ID", "ID ou Nome repetido",
						JOptionPane.PLAIN_MESSAGE);

			}
		} catch (NumberFormatException exception) {
			// Se o id ou o maximo de pessoas nao for um inteiro, ocorre um erro
			JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro", JOptionPane.PLAIN_MESSAGE);

		}
		return resultado;
	}
}
