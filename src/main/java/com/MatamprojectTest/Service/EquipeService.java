package com.MatamprojectTest.Service;

import com.MatamprojectTest.DTO.EquipeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EquipeService {
    ResponseEntity<String> addEquipe(EquipeDTO equipeDTO);

    Page<EquipeDTO> getAllEquipes(Pageable pageable);

    EquipeDTO getEquipeById(Long id);

    ResponseEntity<String> deleteEquipe(Long equipeId);

    List<EquipeDTO> searchEquipesByName(String nomEquipe);

    ResponseEntity<EquipeDTO> updateEquipe(Long equipeId, EquipeDTO equipeDTO);
}
