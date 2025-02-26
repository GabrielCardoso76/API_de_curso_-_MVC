package com.example.API_Curso.banco;

import com.example.API_Curso.model.Aluno;
import com.example.API_Curso.model.Curso;
import com.example.API_Curso.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class CursoBd {
    private List<Curso> cursos;

    public CursoBd() {
        this.cursos = new ArrayList<>();
    }

    //Retorna todos os cursos
    public List<Curso> findAll() {
        return new ArrayList<>(cursos);
    }

    //Retorna com base no nome do professor
    public boolean getByTeacherName(String name) {
        Curso cursoBd = cursos.stream()
                .filter(c -> c.getProfessor().getNome().equals(name))
                .findFirst()
                .orElse(null);

        if (cursoBd == null) {
            return false;
        }
        return true;
    }

    //Retorna com base no número da sala
    public boolean getByRoomNumber(int RoomNumber) {
        Curso cursoBd = cursos.stream()
                .filter(c -> c.getNumeroSala() == RoomNumber)
                .findFirst()
                .orElse(null);

        if (cursoBd == null) {
            return false;
        }
        return true;
    }

    //Retorna com base no ID
    public boolean getByID(int id) {
        Curso cursoBd = cursos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (cursoBd == null) {
            return false;
        }
        return true;
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

        cursoBd.setAlunos(aluno);

        return true;
    }

    //atualiza curso e professor
    public boolean updateCursoAndTeacher(Curso curso, Professor professor){
        Curso cursoBd = cursos.stream()
                .filter(c -> c.getNome().equals(curso.getNome()))
                .findFirst()
                .orElse(null);

        if (cursoBd == null){
            return false;
        }

        cursoBd.setProfessor(professor);
        cursoBd.setNome(curso.getNome());
        cursoBd.setNumeroSala(curso.getNumeroSala());

        return true;
    }

    //atualiza curso e aluno
    public boolean updateCursoAndStudent(Curso curso, Aluno aluno){
        Curso cursoBd = cursos.stream()
                .filter(c -> c.getNome().equals(curso.getNome()))
                .findFirst()
                .orElse(null);

        if (cursoBd == null){
            return false;
        }

        cursoBd.setAlunos(aluno);
        cursoBd.setNome(curso.getNome());
        cursoBd.setNumeroSala(curso.getNumeroSala());

        return true;
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
