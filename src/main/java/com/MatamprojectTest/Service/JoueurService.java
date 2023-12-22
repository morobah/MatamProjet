package com.MatamprojectTest.Service;


import com.MatamprojectTest.DTO.JoueurDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JoueurService {
    ResponseEntity<String> addJoueur(JoueurDTO joueurDTO);

    Page<JoueurDTO> getAllJoueurs(Pageable pageable);

    JoueurDTO getJoueurById(Long id);

    ResponseEntity<String> deleteJoueur(Long joueurId);

    Page<JoueurDTO> searchJoueursByEquipeName(String nomEquipe, Pageable pageable);

    ResponseEntity<JoueurDTO> updateJoueur(Long joueurId, JoueurDTO joueurDTO);

    List<JoueurDTO> getJoueursByEquipe(Long equipeId);
}