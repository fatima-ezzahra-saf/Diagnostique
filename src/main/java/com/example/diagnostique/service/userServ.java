package com.example.diagnostique.service;

import com.example.diagnostique.entities.Qst;
import com.example.diagnostique.entities.Reponse;
import com.example.diagnostique.entities.Respo;
import com.example.diagnostique.entities.cat_qst;

import java.util.List;

public interface userServ {
    List<Respo> getAllUsers();
    List<Qst> getAllQsts();
    List<cat_qst> getAllCats();
}
