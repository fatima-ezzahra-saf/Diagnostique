package com.example.diagnostique.service;

import com.example.diagnostique.Repository.catsRepos;
import com.example.diagnostique.Repository.qstRepos;
import com.example.diagnostique.Repository.reponseRepos;
import com.example.diagnostique.Repository.userRepos;
import com.example.diagnostique.entities.Qst;
import com.example.diagnostique.entities.Reponse;
import com.example.diagnostique.entities.Respo;
import com.example.diagnostique.entities.cat_qst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userServImp implements userServ{
    @Autowired
    private userRepos userRepos;
    @Autowired
    private qstRepos qstRepos;
    @Autowired
    private catsRepos catRepos;
    @Autowired
    private reponseRepos reponseRepos;

    @Override
    public List<Respo> getAllUsers() {
         return userRepos.findAll();
    }

    @Override
    public List<Qst> getAllQsts() {
        return qstRepos.findAll();
    }

    @Override
    public List<cat_qst> getAllCats() {
        return catRepos.findAll();
    }

}
