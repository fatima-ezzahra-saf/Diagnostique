package com.example.diagnostique.Repository;

import com.example.diagnostique.entities.Respo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userRepos extends JpaRepository<Respo,Long> {
    @Query("SELECT r FROM Respo r WHERE r.id=?1")
    Respo findUserById(Long id);
}
