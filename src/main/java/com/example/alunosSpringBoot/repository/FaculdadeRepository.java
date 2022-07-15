package com.example.alunosSpringBoot.repository;

import com.example.alunosSpringBoot.model.Faculdade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("faculdadeRepository")
public interface FaculdadeRepository extends JpaRepository<Faculdade, Integer> {

}
