package controller;

import javax.swing.JOptionPane;
import model.*;
import model.model_database.Database;

public class ControlePessoas {

	public ControlePessoas() {
		
	}
	
	public static String[] getNomePessoas(int pos) {
    	String string[] = new String[Database.getGrupos().get(pos).getQtde_pessoas()];
    	for(int i = 0; i < Database.getGrupos().get(pos).getQtde_pessoas(); i++) {
    		string[i] = Database.getGrupos().get(pos).getPessoas().get(i).getNome();
    	}
    	return string;
    }
	
	public static void cadastrarPessoa(String nomeString, String id_userString, String cpfString, String id_grupoString) {
    	try {
            boolean nao_repete = true;
    		int id_user = Integer.parseInt(id_userString);
            int id_grupo = Integer.parseInt(id_grupoString);
            
            //Repeticao de id de usuario
           for(int j = 0; j < Database.getQtde_grupos(); j++) {
        	   if(Database.getGrupos().get(j).getQtde_pessoas() == 0) {
        		   continue;
        	   }
        	   
        	   for(int k = 0; k < Database.getGrupos().get(j).getQtde_pessoas(); k++) {
            		if(Database.getGrupos().get(j).getPessoas().get(k).getId() == id_user) {
            			nao_repete = false;
            			break;
            		}              	
            	}
            	if(nao_repete == false) {
            		break;
            	}
            }
            
           if(nao_repete == true) {
                for(int i = 0; i < Database.getQtde_grupos(); i++) {
                	if(Database.getGrupos().get(i).getId() == id_grupo) {
                		Pessoa new_user = new Pessoa(cpfString, nomeString, id_user);
                		
                		Database.getGrupos().get(i).setNova_pessoa(new_user);
                		Database.getGrupos().get(i).add_pessoa();
                		JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", 
 														"Cadastro", JOptionPane.PLAIN_MESSAGE);
                		
                		break;
                	}
                	else if(i == (Database.getQtde_grupos() - 1)) {
                        JOptionPane.showMessageDialog(null, "Nao encontramos um grupo com o ID inserido", 
                        								"Grupo nao encontrado", JOptionPane.PLAIN_MESSAGE);
                	}
                }
            }
            else {
            	JOptionPane.showMessageDialog(null, "Ja existe um usuario com esse ID", 
						"ID repetido", JOptionPane.PLAIN_MESSAGE);
            }
            
        } catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
            								"Erro", JOptionPane.PLAIN_MESSAGE);
        }
    }
	
}
