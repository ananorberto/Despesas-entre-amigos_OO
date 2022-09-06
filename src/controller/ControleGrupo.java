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
	 * @param nomeString       String Retorna nome do grupo.
	 * @param idString         String Retorna ID do grupo.
	 * @param maxPessoasString String Retorna quantidade maxima de pessoas no grupo
	 */

	public static void cadastrarGrupo(String nomeString, String idString, String maxPessoasString) {
		boolean naoRepete = true;

		try {
			int idInt = Integer.parseInt(idString);
			int maxPessoasInt = Integer.parseInt(maxPessoasString);

			for (int i = 0; i < Database.getQtdeGrupos(); i++) {
				if (Database.getGrupos().get(i).getId() == idInt) {
					naoRepete = false;
					break;
				}
			}

			if (naoRepete == true) {
				Grupo novoGrupo = new Grupo(maxPessoasInt, idInt, nomeString);

				Database.getGrupos().add(novoGrupo);
				Database.aumentarQtdeGrupos();

				JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro",
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Ja existe um grupo com esse ID", "ID repetido",
						JOptionPane.PLAIN_MESSAGE);

			}
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro", JOptionPane.PLAIN_MESSAGE);

		}
	}
}
