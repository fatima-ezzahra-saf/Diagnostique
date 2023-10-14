package com.example.diagnostique.Repository;

import com.example.diagnostique.entities.choix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface choixRepos extends JpaRepository <choix,Long> {
}
