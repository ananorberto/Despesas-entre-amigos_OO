package model_database;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class Database {
    private static final List<Grupo> GRUPOS = new ArrayList<>();

    private Database(){
    }
    public static  List<Grupo> getGrupos(){
        return GRUPOS;
    }
}
