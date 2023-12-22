package com.MatamprojectTest.Repository;

import com.MatamprojectTest.Model.Joueur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

    Page<Joueur> findAll(Pageable pageable);
    Page<Joueur> findByEquipeNomEquipeContainingIgnoreCase(String nomEquipe, Pageable pageable);
    List<Joueur> findByEquipeId(Long equipeId);
}
