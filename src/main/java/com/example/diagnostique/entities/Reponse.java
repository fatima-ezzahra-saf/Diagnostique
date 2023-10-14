package com.example.diagnostique.entities;

import jakarta.persistence.*;

@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private choix choix;
    @ManyToOne
    private Respo respo;
    @ManyToOne
    private Qst qst;

    public Reponse() {
    }

    public Reponse( com.example.diagnostique.entities.choix choix, Respo respo, Qst qst) {
        this.choix = choix;
        this.respo = respo;
        this.qst = qst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.example.diagnostique.entities.choix getChoix() {
        return choix;
    }

    public void setChoix(choix choix) {
        this.choix = choix;
    }

    public Respo getRespo() {
        return respo;
    }

    public void setRespo(Respo respo) {
        this.respo = respo;
    }

    public Qst getQst() {
        return qst;
    }

    public void setQst(Qst qst) {
        this.qst = qst;
    }


}
