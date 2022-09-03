package controller;

import javax.swing.JOptionPane;

import model.Compra;
import model.Imovel;
import model.model_database.Database;

public class ControleDespesa {

	public ControleDespesa() {
		
	}
	
	public static void cadastrarCompra(String nome_mercadoString, String id_pagadorString, String id_grupoString,
										String itensString, String valorString, String dataString) {
		 try {
			 boolean acabou = false;
             int id_pagadorInt = Integer.parseInt(id_pagadorString);
             int id_grupoInt = Integer.parseInt(id_grupoString);
             double valorDouble = Double.parseDouble(valorString);
             
             for(int i = 0; i < Database.getQtde_grupos(); i++) {
             	if( Database.getGrupos().get(i).getId() == id_grupoInt) {
             		//Achou o grupo
             		for(int j = 0; j < Database.getGrupos().get(i).getQtde_pessoas(); j++) {
             			if(Database.getGrupos().get(i).getPessoas().get(j).getId() == id_pagadorInt) {
             				//Achou a pessoa
             				acabou = true;
	                			Compra nova_compra = new Compra(nome_mercadoString, valorDouble, dataString, 
		                											id_pagadorInt, id_grupoInt, itensString);
		                		Database.getGrupos().get(i).getDespesas().add(nova_compra);
		                		Database.getGrupos().get(i).aumentar_qtde_despesas();	                		
		                		Database.getGrupos().get(i).getPessoas().get(j).setTotal_despesa(valorDouble);
		                		
		                		JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", 
		 														"Cadastro", JOptionPane.PLAIN_MESSAGE);
                             
		                		
		                		break;
	                		}
             			else if(j == (Database.getGrupos().get(i).getQtde_despesas() - 1)){
             				//Nao achou a pessoa
             				JOptionPane.showMessageDialog(null, "Nao encontramos uma pessoa ou um grupo com os IDs inseridos", 
      								"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
	                			acabou = true;

                             
	                		}
	  
             		}
             		if(acabou == true) {
             			//Parar de procurar os grupos assim que encontrar a pessoa
             			break;
             		}
             	
             	}
             	else if(i == (Database.getQtde_grupos() - 1)) {
             		//Nao achou o grupo
             		JOptionPane.showMessageDialog(null, "Nao encontramos uma pessoa ou grupo com o ID inserido", 
                     								"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
                     
             	}
             }

         }
         catch(NumberFormatException exception){
         	JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
             								"Erro", JOptionPane.PLAIN_MESSAGE);
             
         }
		
	}
	
	public static void cadastrarImovel(String enderecoString, String conta_luzString, String conta_aguaString, 
						String aluguelString, String dataString, String id_pagadorString, String id_grupoString) {
		
		 try {
			 boolean acabou = false;
             int id_pagadorInt = Integer.parseInt(id_pagadorString);
             int id_grupoInt = Integer.parseInt(id_grupoString);
             double conta_luzDouble = Double.parseDouble(conta_luzString);
             double conta_aguaDouble = Double.parseDouble(conta_aguaString);
             double aluguelDouble = Double.parseDouble(aluguelString);

             for(int i = 0; i < Database.getQtde_grupos(); i++) {
             	if( Database.getGrupos().get(i).getId() == id_grupoInt) {
             		//Achou o grupo
             		for(int j = 0; j < Database.getGrupos().get(i).getQtde_pessoas(); j++) {
             			if(Database.getGrupos().get(i).getPessoas().get(j).getId() == id_pagadorInt) {
             				//Achou a pessoa
             				acabou = true;
	                			Imovel novo_imovel = new Imovel(enderecoString, conta_luzDouble, conta_aguaDouble, 
	                											aluguelDouble, dataString, id_pagadorInt, id_grupoInt);
	                			
		                		novo_imovel.somar_gastos();
	                			
	                			Database.getGrupos().get(i).getDespesas().add(novo_imovel);
		                		Database.getGrupos().get(i).aumentar_qtde_despesas();
		                		Database.getGrupos().get(i).getPessoas().get(j).setTotal_despesa(novo_imovel.getValor());
		                		
		                		JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", 
		 														"Cadastro", JOptionPane.PLAIN_MESSAGE);
		                		
		                		break;
	                		}
             			else if(j == (Database.getGrupos().get(i).getQtde_despesas() - 1)){
             				//Nao achou a pessoa
             				JOptionPane.showMessageDialog(null, "Nao encontramos uma pessoa ou um grupo com os IDs inseridos", 
             						"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
	                			acabou = true;
	                		}
	  
             		}
             		if(acabou == true) {
             			//Parar de procurar os grupos assim que encontrar a pessoa
             			break;
             		}
             	
             	}
             	else if(i == (Database.getQtde_grupos() - 1)) {
             		//Nao achou o grupo
             		JOptionPane.showMessageDialog(null, "Nao encontramos uma pessoa ou um grupo com os IDs inseridos", 
             											"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
             	}
             }

         }
         catch(NumberFormatException exception){
         	JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
             								"Erro", JOptionPane.PLAIN_MESSAGE);
         }
	}
}
