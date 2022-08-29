package model_database;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class Database {
    private static final List<Grupo> GRUPOS = new ArrayList<>();
    private static int qtde_grupos = 0;
    private static Grupo g1 = new Grupo(3, 100, "grupo1");
    private static Grupo g2 = new Grupo(3, 101, "grupo2");
    private static Grupo g3 = new Grupo(3, 102, "grupo3");
    
    
    private Database(){
    }
        
    public static int getQtde_grupos() {
		return qtde_grupos;
	}


	public static void aumentar_contador_grupos() {
		qtde_grupos = qtde_grupos + 1;
	}


	public static  List<Grupo> getGrupos(){
        return GRUPOS;
    }
	
	public static void pre_cadastrar_grupos() {
		GRUPOS.add(g1);
		GRUPOS.add(g2);
		GRUPOS.add(g3);
		qtde_grupos = 3;
	}
	
}
