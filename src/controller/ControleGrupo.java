package controller;

import model.*;
import view.*;
import model.model_database.Database;

 public class ControleGrupo{
     private Grupo[] grupos;
     private int Qtde_grupos;

     public ControleGrupo(ControleData database){
         grupos = Database.getGrupos().toArray(new Grupo[0]);
     }
     public String[] getNomeGrupo(){

         String[] string = new String[Qtde_grupos];
         for (int i = 0; i < Qtde_grupos; i++){
             string[i] = grupos[i].getNome();
         }
         return string;
     }
     public Grupo[] getGrupos(){
         return grupos;
     }
     public int getQtde(){
         return Qtde_grupos;
     }
     public void setQtde(int qtde){
         this.Qtde_grupos = qtde;
     }
     public int getQtde_grupos(){

         return Qtde_grupos;
     }

     public void setQtde_grupos(int qtde_grupos){

         this.Qtde_grupos = qtde_grupos;
     }
     public String getNome(int i){

         return grupos[i].getNome();
     }
     public int getId(int i){

         return grupos[i].getId();
     }
     public int getMax_pessoas(int i){

         return grupos[i].getMax_pessoas();
     }
 }

