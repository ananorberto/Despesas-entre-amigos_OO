package controller;

import javax.swing.JOptionPane;

import model.Grupo;
import model.model_database.Database;



public class ControleGrupo {

    public ControleGrupo(Database database) {
    }

    public static String[] getNomeGrupo() {

        String[] string = new String[Database.getQtde_grupos()];
        for (int i = 0; i < Database.getQtde_grupos(); i++) {
            string[i] = Database.getGrupos().get(i).getNome();
        }
        return string;
    }
    
    public static void cadastrarGrupo(String nomeString, String idString, String max_pessoasString) {
    	boolean nao_repete = true;
    	
    	try {
			int idInt = Integer.parseInt(idString);
			int max_pessoasInt = Integer.parseInt(max_pessoasString);

			for(int i = 0; i < Database.getQtde_grupos(); i++) {
				if(Database.getGrupos().get(i).getId() == idInt) {
					nao_repete = false;
					break;
				}
			}
			
			
			if(nao_repete == true) {
				Grupo novo_grupo = new Grupo(max_pessoasInt, idInt, nomeString);
				
				Database.getGrupos().add(novo_grupo);
				Database.aumentar_contador_grupos();

				JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro",
						JOptionPane.PLAIN_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Ja existe um grupo com esse ID",
												"ID repetido", JOptionPane.PLAIN_MESSAGE);
				
			}
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
											"Erro", JOptionPane.PLAIN_MESSAGE);

		}
    }
}
    


