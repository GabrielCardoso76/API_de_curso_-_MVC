package com.example.API_Curso.controller;

import com.example.API_Curso.banco.CursoBd;
import com.example.API_Curso.model.Aluno;
import com.example.API_Curso.model.Curso;
import com.example.API_Curso.model.Professor;

import java.util.List;

public class CursoController {
    CursoBd repository = new CursoBd();

    public List<Curso> findAll(){
        return repository.findAll();
    }
    public List<Curso> getByTeacherName(String name){
        return repository.getByTeacherName(name);
    }
    public List<Curso> getByRoomNumber(int RoomNumber){
        return repository.getByRoomNumber(RoomNumber);
    }
    public List<Curso> getByID(int id){
        return repository.getByID(id);
    }
    public boolean insert(Curso curso){
        return repository.insert(curso);
    }
    public boolean insertStudent(String cursoName, Aluno aluno){
        return repository.insertStudent(cursoName , aluno);
    }
    public Curso updateCursoAndTeacher(Long id,Curso curso){
        return repository.updateCursoAndTeacher(id,curso);
    }
    public Curso updateCursoAndStudent(Long id, Curso curso){
        return repository.updateCursoAndStudent(id, curso);
    }
    public boolean delete(Long id){
        return repository.delete(id);
    }
}
