package com.example.diagnostique.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class cat_qst {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    public cat_qst(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public cat_qst() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
