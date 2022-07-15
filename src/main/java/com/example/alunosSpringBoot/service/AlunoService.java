package com.example.alunosSpringBoot.service;

import com.example.alunosSpringBoot.model.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoService {

    Optional<Aluno> getAlunoById(Integer id);

    List<Aluno> getAllAlunos();

    void deleteAllAlunos();

    void deleteAlunoById(Integer id);

    void updateAlunoById(Integer id, Aluno aluno);

    void updateAluno(Aluno aluno);

    void insertAluno(Aluno aluno);

    Optional<Aluno> getAllAlunosByFaculdade(Integer idFaculdade);

    List<Aluno> getAllAlunosByEmail(String email);
    List<Aluno> getAllAlunoByFaculdadeAndEmail(Integer idFaculdade, String email);

}