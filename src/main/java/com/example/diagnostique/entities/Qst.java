package com.example.diagnostique.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Qst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qst;

    @ManyToOne
    private cat_qst cat;

    public Qst() {
    }

    public Qst(Long id, String qst, cat_qst cat) {
        this.id = id;
        this.qst = qst;
        this.cat = cat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQst() {
        return qst;
    }

    public void setQst(String qst) {
        this.qst = qst;
    }


    public cat_qst getCat() {
        return cat;
    }

    public void setCat(cat_qst cat) {
        this.cat = cat;
    }
}
