package DAO;

import Model.Aluno;
import java.util.*;

public class AlunoDAO {

    public static ArrayList<Aluno> minhaLista = new ArrayList<Aluno>();

    public static int maiorId() {
        int maiorId = 0;
        for (int i = 0; i < minhaLista.size(); i++) {
            if (minhaLista.get(i).getId() > maiorId) {
                maiorId = minhaLista.get(i).getId();
            }
        }
    return maiorId;
    
    }
    

}
