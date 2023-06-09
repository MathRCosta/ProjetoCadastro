package Model;

import java.util.*;
import DAO.AlunoDAO;

public class Aluno extends Pessoa {
// Atributos

    private String curso;
    private int fase;
// Método Construtor de Objeto Vazio

    public Aluno() {
    }
// Método Construtor de Objeto, inserindo dados

    public Aluno(String curso, int fase) {
        this.curso = curso;
        this.fase = fase;
    }
// Método Construtor usando também o construtor da SUPERCLASSE

    public Aluno(String curso, int fase, int id, String nome, int idade) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
    }
// Métodos GET e SET

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }
// Override necessário para poder retornar os dados de
// Pessoa no toString para aluno.

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Idade: " + this.getIdade()
                + "\n Curso: " + this.getCurso()
                + "\n Fase:" + this.getFase()
                + "\n -----------";
    }

    /* ABAIXO OS MÉTODOS PARA USO JUNTO COM O DAO
SIMULANDO A ESTRUTURA EM CAMADAS PARA
USAR COM BANCOS DE DADOS. */
// Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        return AlunoDAO.minhaLista;
    }
// Cadastra novo aluno

    public boolean InsertAlunoBD(String curso, int fase, String nome, int idade) {
//        
        AlunoDAO objetoID = new AlunoDAO();
        int id = objetoID.maiorId() + 1;
        Aluno objeto = new Aluno(curso, fase, id, nome, idade);
        AlunoDAO.minhaLista.add(objeto);
        return true;
    }
// Deleta um aluno específico pelo seu campo ID

    public boolean DeleteAlunoBD(int id) {
        int indice = this.procuraIndice(id);
        AlunoDAO.minhaLista.remove(indice);
        return true;
    }

// Edita um aluno específico pelo seu campo ID
    public boolean UpdateAlunoBD(String curso, int fase, int id, String nome, int idade) {
        Aluno objeto = new Aluno(curso, fase, id, nome, idade);
        int indice = this.procuraIndice(id);
        AlunoDAO.minhaLista.set(indice, objeto);
        return true;
    }
// procura o INDICE de objeto da MinhaLista que contem o ID enviado.

    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < AlunoDAO.minhaLista.size(); i++) {
            if (AlunoDAO.minhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

}
