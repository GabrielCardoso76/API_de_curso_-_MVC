package com.example.API_Curso.view;

import com.example.API_Curso.controller.CursoController;
import com.example.API_Curso.model.Aluno;
import com.example.API_Curso.model.Curso;
import com.example.API_Curso.model.Professor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoView {
    CursoController cursoController = new CursoController();

    @GetMapping
    public List<Curso> findAll(){
        return cursoController.findAll();
    }

    @GetMapping("/profname/{name}")
    public List<Curso> getByTeacherName(@PathVariable String name){
        return cursoController.getByTeacherName(name);
    }

    @GetMapping("/numerosala/{RoomNumber}")
    public List<Curso> getByRoomNumber(@PathVariable int RoomNumber){
        return cursoController.getByRoomNumber(RoomNumber);
    }

    @GetMapping("/id/{id}")
    public List<Curso> getByID(@PathVariable int id){
        return cursoController.getByID(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Curso curso){
        return cursoController.insert(curso);
    }

    @PostMapping("/inserirEstudante/{cursoName}")
    public boolean insertStudent(@PathVariable String cursoName,@RequestBody Aluno aluno){
        return cursoController.insertStudent(cursoName, aluno);
    }

    @PutMapping("/atualizarProfessor/{id}")
    public Curso updateCursoAndTeacher(@PathVariable Long id, @RequestBody Curso curso){
        return cursoController.updateCursoAndTeacher(id, curso);
    }

    @PutMapping("/atualizarAluno/{id}")
    public Curso updateCursoAndStudent(@PathVariable Long id, @RequestBody Curso curso){
        return cursoController.updateCursoAndStudent(id, curso);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return cursoController.delete(id);
    }
}
