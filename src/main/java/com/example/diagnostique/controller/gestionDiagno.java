package com.example.diagnostique.controller;

import com.example.diagnostique.Repository.*;
import com.example.diagnostique.entities.*;
import com.example.diagnostique.service.userServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class gestionDiagno {
    @Autowired
    private userServ ser;
    @Autowired
    private qstRepos qstRepos;
    @Autowired
    private choixRepos choixRepos;
    @Autowired
    private reponseRepos reponseRepos;
    @Autowired
    private catsRepos catsRepos;
    @Autowired
    private diagnoRepos diagnoRepos;
    @Autowired
    private userRepos userRepos;


    //partie Auth
    @PostMapping(path = "/Login")
    public String auth(@RequestBody Respo r){
        List<Respo> respos=ser.getAllUsers();
        for (int i=0;i<respos.size();i++){
            if (respos.get(i).getPassword().equals(r.getPassword()) && respos.get(i).getLogin().equals(r.getLogin())) return  respos.get(i).getId().toString();
        }
        return "non";
    }


    //partie diagnostique
    @GetMapping(path="/get_catg")
    public List<cat_qst> getCat() {
        List<cat_qst> categ = catsRepos.findAll();
        return categ;
    }

    @GetMapping(path ="/get_qst")
    public List<Qst> get_qst(){
        List<Qst> qsts=ser.getAllQsts();

        return qsts;
    }

    @GetMapping(path="/get_choix")
    public List<choix> get_choix(){
        return choixRepos.findAll();
    }

    @GetMapping(path="/get_qsts_by_cat/{cat_id}")
    public List<Qst> get_qsts_by_cat(@PathVariable Long cat_id){
        List<Qst> q=qstRepos.findAllByCat(cat_id);
        return q;
    }

    @GetMapping(path="/Responses")
    public List<Reponse> getAll(){
       List<Reponse> r= reponseRepos.findAll();
       return r;
    }
    @PostMapping(path="/reponses/{id_respo}")
    public List<Reponse> getReponsesByUser(@PathVariable Long id_respo) {
        List<Reponse> r = reponseRepos.getRepByUser(id_respo);
        return r;
    }

    @PostMapping(path="/Enregistrer")
    public void getAllResponses(@RequestBody List<Reponse> R){
         reponseRepos.saveAll(R);
    }



    //diagno finale
    @GetMapping(path="/diagno_final/{id_respo}")
    public List<Reponse> getReponseByUser(@PathVariable Long id_respo){
        List<Reponse> r=reponseRepos.getRepByUser(id_respo);
        return r;
    }
    @GetMapping(path="/get_scoreByCat/{id_respo}")
    public List<Diagnostique> get_scoreByCat(@PathVariable Long id_respo) {
        List<Diagnostique> diagnostics = diagnoRepos.findAllByUserId(id_respo);
        List<Reponse> rs = reponseRepos.getRepByUser(id_respo);
        List<cat_qst> cats = catsRepos.findAll();
        int score = 0;
        for (int i = 0; i < cats.size(); i++) {
            List<Qst> qsts = qstRepos.findAllByCat(cats.get(i).getId());
            for (int j = 0; j < qsts.size(); j++) {
                for (int k = 0; k < rs.size(); k++) {
                    if (qsts.get(j).getId() == rs.get(k).getQst().getId())
                        score += rs.get(k).getChoix().getNote();
                }
            }
            Diagnostique existingDiag = diagnoRepos.findByRespoIdAndCat_qstId(id_respo, cats.get(i).getId());
            if (existingDiag != null) {
                existingDiag.setScoreByCat(score);
                diagnoRepos.save(existingDiag);
            } else {
                Diagnostique D = new Diagnostique();
                D.setScoreByCat(score);
                D.setCat_qst(cats.get(i));
                D.setRespo(userRepos.findUserById(id_respo));
                diagnostics.add(D);
                diagnoRepos.save(D);
            }
            score = 0;
        }
         return diagnostics;
    }
}
