package com.example.diagnostique.Repository;

import com.example.diagnostique.entities.Qst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface qstRepos extends JpaRepository<Qst,Long> {
    @Query("SELECT q FROM Qst q where q.cat.id= ?1")
    List<Qst> findAllByCat(Long id);
}
