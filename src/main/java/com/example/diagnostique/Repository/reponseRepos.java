package com.example.diagnostique.Repository;

import com.example.diagnostique.entities.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface reponseRepos extends JpaRepository<Reponse,Long> {
    @Query("select r from Reponse r where r.respo.id=?1")
    List<Reponse> getRepByUser(Long id);
}
