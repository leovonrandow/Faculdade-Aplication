package com.example.alunosSpringBoot.controller;

import com.example.alunosSpringBoot.model.Aluno;
import com.example.alunosSpringBoot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlunoRestController {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value = "/rest/alunos/getall", method = RequestMethod.GET)
    public List<Aluno> getAlunos(){
        return alunoService.getAllAlunos();
    }

    @RequestMapping(value = "/rest/alunos/get/{id}", method = RequestMethod.GET)
    public Optional<Aluno> getAluno(@PathVariable("id") Integer id) {
        return alunoService.getAlunoById(id);
    }

    @RequestMapping(value = "/rest/alunos/getAllByFaculdade/{id}", method = RequestMethod.GET)
    public Optional<Aluno> getAllByFaculdade(@PathVariable("id") Integer id) {
        return alunoService.getAllAlunosByFaculdade(id);
    }

    @RequestMapping(value = "/rest/alunos/getAllByEmail/{email}", method = RequestMethod.GET)
    public List<Aluno> getAllByEmail(@PathVariable("email") String email) {
        return alunoService.getAllAlunosByEmail(email);
    }


    @RequestMapping(value = "/rest/alunos/deleteAll", method = RequestMethod.DELETE)
    public void deleteAlunos() {
        alunoService.deleteAllAlunos();
    }

    @RequestMapping(value = "/rest/alunos/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAluno(@PathVariable("id") Integer id) {
        alunoService.deleteAlunoById(id);
    }

    @RequestMapping(value = "/rest/alunos/update/{id}", method = RequestMethod.POST)
    public void updateAluno(@RequestBody Aluno aluno, @PathVariable("id") Integer id) {
        alunoService.updateAlunoById(id, aluno);
    }

    @RequestMapping(value = "/rest/alunos/insert", method = RequestMethod.POST)
    public void updateAluno(@RequestBody Aluno aluno) {
        alunoService.insertAluno(aluno);
    }

}
