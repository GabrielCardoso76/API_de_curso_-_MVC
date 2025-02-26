package com.example.API_Curso.banco;

import com.example.API_Curso.model.Aluno;
import com.example.API_Curso.model.Curso;
import com.example.API_Curso.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class CursoBd {
    private List<Curso> cursos;

    public CursoBd(){
        this.cursos = new ArrayList<>();

        // Criando os objetos Aluno e Professor
        Aluno aluno1 = new Aluno(1L, "Joao", "12345678");
        Aluno aluno2 = new Aluno(2L, "Gustavo", "12349678");
        Aluno aluno3 = new Aluno(3L, "Antony", "12341600");
        Professor professor1 = new Professor(1L, "Leonardo", "11122233444", 110000);
        Professor professor2 = new Professor(2L, "Fabiana", "11000000000", 10);
        Professor professor3 = new Professor(3L, "Wesley", "00000000004", 190000);

        // Criando a lista de alunos
        ArrayList<Aluno> alunosTeste = new ArrayList<Aluno>();
        alunosTeste.add(aluno1);
        alunosTeste.add(aluno2);
        alunosTeste.add(aluno3);

        // Criando o curso e associando o professor e a lista de alunos
        Curso curso1 = new Curso(1L, "Java1", 22, alunosTeste, professor1);
        Curso curso2 = new Curso(2L, "Java2", 23, alunosTeste, professor2);
        Curso curso3 = new Curso(3L, "Java3", 24, alunosTeste, professor3);

        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
    }

    //Retorna todos os cursos
    public List<Curso> findAll() {
        return new ArrayList<>(cursos);
    }

    //Retorna com base no nome do professor
    public List<Curso> getByTeacherName(String name) {
        return cursos.stream()
                .filter(c -> c.getProfessor().getNome().equals(name))
                .toList();
    }

    //Retorna com base no número da sala
    public List<Curso> getByRoomNumber(int RoomNumber) {
        return cursos.stream()
                .filter(c -> c.getNumeroSala() == RoomNumber)
                .toList();
    }

    //Retorna com base no ID
    public List<Curso> getByID(int id) {
        return cursos.stream()
                .filter(c -> c.getId() == id)
                .toList();
    }

    // insere um curso
    public boolean insert(Curso curso){
        cursos.add(curso);
        return true;
    }

    // adicionar um aluno a um curso existente
    public boolean insertStudent(String cursoName, Aluno aluno){
        Curso cursoBd = cursos.stream()
                .filter(c -> c.getNome().equals(cursoName))
                .findFirst()
                .orElse(null);

        if (cursoBd == null){
            return false;
        }

        cursoBd.getAlunos().add(aluno);

        return true;
    }

    //atualiza curso e professor
    public Curso updateCursoAndTeacher(Long id, Curso curso){
        Curso cursoBd = cursos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        cursoBd.setProfessor(curso.getProfessor());
        cursoBd.setNome(curso.getNome());
        cursoBd.setNumeroSala(curso.getNumeroSala());

        return cursoBd;
    }

    //atualiza curso e aluno
    public Curso updateCursoAndStudent(Long id, Curso curso){
        Curso cursoBd = cursos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);


        cursoBd.setAlunos(curso.getAlunos());
        cursoBd.setNome(curso.getNome());
        cursoBd.setNumeroSala(curso.getNumeroSala());

        return cursoBd;
    }

    // deletar um curso
    public boolean delete(Long id){
        Curso cursoBd = cursos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (cursoBd == null){
            return false;
        }

        cursos.remove(cursoBd);

        return true;
    }

}
