package com.example.alunosSpringBoot.service;

import com.example.alunosSpringBoot.model.Aluno;
import com.example.alunosSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("alunoService")
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public Optional<Aluno> getAlunoById(Integer id) {

        return alunoRepository.findById(id);

    }

    @Override
    public List<Aluno> getAllAlunos() {

        return alunoRepository.findAll();

    }

    @Override
    public void deleteAllAlunos() {
        alunoRepository.deleteAll();
    }

    @Override
    public void deleteAlunoById(Integer id) {
        alunoRepository.deleteById(id);
    }

    @Override
    public void updateAlunoById(Integer id, Aluno aluno) {
        Optional<Aluno> getAluno = getAlunoById(id);
        getAluno.get().setNome(aluno.getNome());
        getAluno.get().setEmail(aluno.getEmail());
        alunoRepository.save(aluno);
    }

    @Override
    public void updateAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @Override
    public void insertAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @Override
    public Optional<Aluno> getAllAlunosByFaculdade(Integer idFaculdade) {
        return alunoRepository.getAllAlunosByFaculdade(idFaculdade);
    }

    @Override
    public List<Aluno> getAllAlunosByEmail(String email) {
        return alunoRepository.getAllAlunosByEmail(email);
    }

    @Override
    public List<Aluno> getAllAlunoByFaculdadeAndEmail(Integer idFaculdade, String email) {
        return alunoRepository.getAllAlunoByFaculdadeAndEmail(idFaculdade, email);
    }
}