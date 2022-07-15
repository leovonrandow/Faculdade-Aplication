package com.example.alunosSpringBoot.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
public class Aluno {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String email;

    @ManyToOne
    @JoinColumn(name="faculdade_id", nullable=false)
    private Faculdade faculdade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }
    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }
}
