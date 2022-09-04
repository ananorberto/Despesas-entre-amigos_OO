package controller;

import javax.swing.JOptionPane;

import database.Database;
import model.*;

public class ControlePessoas {

	public ControlePessoas() {	
	}
	
	public static String[] getNomePessoas(int pos) {
    	String nomesPessoa[] = new String[Database.getGrupos().get(pos).getQtdePessoas()];
    	for(int i = 0; i < Database.getGrupos().get(pos).getQtdePessoas(); i++) {
    		nomesPessoa[i] = Database.getGrupos().get(pos).getPessoas().get(i).getNome();
    	}
    	return nomesPessoa;
    }
	
	public static void cadastrarPessoa(String nomeString, String idPessoaString, String cpfString, String idGrupoString) {
    	try {
            boolean naoRepete = true;
            boolean grupoCheio;
    		int idPessoaInt = Integer.parseInt(idPessoaString);
            int idGrupoInt = Integer.parseInt(idGrupoString);
            
            //Repeticao de id de usuario
           for(int j = 0; j < Database.getQtdeGrupos(); j++) {
        	   if(Database.getGrupos().get(j).getQtdePessoas() == 0) {
        		   continue;
        	   }
        	   
        	   for(int k = 0; k < Database.getGrupos().get(j).getQtdePessoas(); k++) {
            		if(Database.getGrupos().get(j).getPessoas().get(k).getId() == idPessoaInt) {
            			naoRepete = false;
            			break;
            		}              	
            	}
            	if(naoRepete == false) {
            		break;
            	}
            }
            
           if(naoRepete == true) {
                for(int i = 0; i < Database.getQtdeGrupos(); i++) {
                	if(Database.getGrupos().get(i).getId() == idGrupoInt) {
                		Pessoa novaPessoa = new Pessoa(cpfString, nomeString, idPessoaInt);
                		
                		Database.getGrupos().get(i).setNovaPessoa(novaPessoa);
                		grupoCheio = Database.getGrupos().get(i).addPessoa();
                		
                		if(grupoCheio == false) {
                			JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", 
 														  "Cadastro", JOptionPane.PLAIN_MESSAGE);
                		}
                		
                		break;
                	}
                	else if(i == (Database.getQtdeGrupos() - 1)) {
                        JOptionPane.showMessageDialog(null, "Nao encontramos um grupo com o ID inserido", 
                        							  "Grupo nao encontrado", JOptionPane.PLAIN_MESSAGE);
                	}
                }
            }
            else {
            	JOptionPane.showMessageDialog(null, "Ja existe um usuario com esse ID", 
											  "ID repetido", JOptionPane.PLAIN_MESSAGE);
            }
            
        } 
    	catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
            							  "Erro", JOptionPane.PLAIN_MESSAGE);
        }
    }
	
}
