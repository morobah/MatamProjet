package com.MatamprojectTest.Repository;

import com.MatamprojectTest.Model.Equipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

     Page<Equipe> findAll(Pageable pageable) ;

     Optional<Equipe> findById(Long id);
     @Query("SELECT e FROM Equipe e WHERE LOWER(e.NomEquipe) LIKE LOWER(CONCAT('%', :nomEquipe, '%'))")
     List<Equipe> findByNomEquipeContainingIgnoreCase(@Param("nomEquipe") String nomEquipe);

     List<Equipe> findByBudgetGreaterThan(double budget);
}


