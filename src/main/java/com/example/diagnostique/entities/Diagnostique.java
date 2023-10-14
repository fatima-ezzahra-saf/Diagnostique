package com.example.diagnostique.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Diagnostique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private cat_qst cat_qst;
    @ManyToOne
    private Respo respo;

    private int scoreByCat;

    public Respo getRespo() {
        return respo;
    }

    public void setRespo(Respo respo) {
        this.respo = respo;
    }

    public Diagnostique() {
    }

    public Diagnostique(Long id, Reponse reponse, com.example.diagnostique.entities.cat_qst cat_qst, int scoreByCat) {
        this.id = id;

        this.scoreByCat = scoreByCat;
    }

    public com.example.diagnostique.entities.cat_qst getCat_qst() {
        return cat_qst;
    }

    public void setCat_qst(com.example.diagnostique.entities.cat_qst cat_qst) {
        this.cat_qst = cat_qst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScoreByCat() {
        return scoreByCat;
    }

    public void setScoreByCat(int scoreByCat) {
        this.scoreByCat = scoreByCat;
    }
}
