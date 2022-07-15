package com.example.alunosSpringBoot.repository;

import com.example.alunosSpringBoot.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("alunoRepository")
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query(value = "SELECT * FROM ALUNO WHERE faculdade_id = ?1", nativeQuery = true)
    Optional<Aluno> getAllAlunosByFaculdade(Integer idFaculdade);

    @Query(value = "SELECT * FROM ALUNO WHERE email = ?1", nativeQuery = true)
    List<Aluno> getAllAlunosByEmail(String email);

    @Query(value = "SELECT * FROM ALUNO WHERE faculdade_id = ?1 AND email = ?2", nativeQuery = true)
    List<Aluno> getAllAlunoByFaculdadeAndEmail(Integer idFaculdade, String email);
}
