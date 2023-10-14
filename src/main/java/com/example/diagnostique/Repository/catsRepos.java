package com.example.diagnostique.Repository;

import com.example.diagnostique.entities.cat_qst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface catsRepos extends JpaRepository<cat_qst,Long> {

}
