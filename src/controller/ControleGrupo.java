package controller;

import model.*;

import view.*;
import model.model_database.Database;

 public class ControleGrupo{

     public ControleGrupo(){
     }
     
     public static String[] getNomeGrupo(){

         String[] string = new String[Database.getQtde_grupos()];
         for (int i = 0; i < Database.getQtde_grupos(); i++){
             string[i] = Database.getGrupos().get(i).getNome();
         }
         return string;
     }
    
 }

