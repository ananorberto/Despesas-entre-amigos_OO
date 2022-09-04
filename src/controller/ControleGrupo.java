package controller;

import javax.swing.JOptionPane;

import database.Database;
import model.Grupo;



public class ControleGrupo {

    public ControleGrupo() {
    }

    public static String[] getNomeGrupo() {

        String[] nomesGrupo = new String[Database.getQtdeGrupos()];
        for (int i = 0; i < Database.getQtdeGrupos(); i++) {
            nomesGrupo[i] = Database.getGrupos().get(i).getNome();
        }
        return nomesGrupo;
    }
    
    public static void cadastrarGrupo(String nomeString, String idString, String maxPessoasString) {
    	boolean naoRepete = true;
    	
    	try {
			int idInt = Integer.parseInt(idString);
			int maxPessoasInt = Integer.parseInt(maxPessoasString);

			for(int i = 0; i < Database.getQtdeGrupos(); i++) {
				if(Database.getGrupos().get(i).getId() == idInt) {
					naoRepete = false;
					break;
				}
			}
			
			
			if(naoRepete == true) {
				Grupo novoGrupo = new Grupo(maxPessoasInt, idInt, nomeString);
				
				Database.getGrupos().add(novoGrupo);
				Database.aumentarQtdeGrupos();

				JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro",
											  JOptionPane.PLAIN_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Ja existe um grupo com esse ID",
											  "ID repetido", JOptionPane.PLAIN_MESSAGE);
				
			}
		} 
    	catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
										  "Erro", JOptionPane.PLAIN_MESSAGE);

		}
    }
}
    


