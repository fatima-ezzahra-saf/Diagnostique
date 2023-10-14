package com.example.diagnostique.Repository;

import com.example.diagnostique.entities.Diagnostique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface diagnoRepos extends JpaRepository<Diagnostique,Long> {
    @Query("select D from Diagnostique D where D.respo.id=?1")
    List<Diagnostique> findAllByUserId(Long id_respo);

    @Query("select d from Diagnostique d where d.respo.id=?1 and d.cat_qst.id=?2")
    Diagnostique findByRespoIdAndCat_qstId(Long id_respo, Long id_cat);
}
