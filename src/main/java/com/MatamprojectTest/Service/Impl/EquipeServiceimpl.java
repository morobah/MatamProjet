package com.MatamprojectTest.Service.Impl;

import com.MatamprojectTest.DTO.EquipeDTO;
import com.MatamprojectTest.Model.Equipe;
import com.MatamprojectTest.Repository.EquipeRepository;
import com.MatamprojectTest.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipeServiceimpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public ResponseEntity<String> addEquipe(EquipeDTO equipeDTO) {
        try {
            Equipe equipe = EquipeDTO.toEntity(equipeDTO);
            Equipe savedEquipe = equipeRepository.save(equipe);
            String successMessage = "Équipe ajoutée avec succès. ID de l'équipe : " + savedEquipe.getId();
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de l'équipe");
        }
    }

    public Page<EquipeDTO> getAllEquipes(Pageable pageable) {
        Page<Equipe> equipePage = equipeRepository.findAll(pageable);
        return equipePage.map(EquipeDTO::fromEntity);
    }

    public EquipeDTO getEquipeById(Long id) {
        Optional<Equipe> equipeOptional = equipeRepository.findById(id);
        return equipeOptional.map(EquipeDTO::fromEntity).orElse(null);
    }

    public ResponseEntity<String> deleteEquipe(Long equipeId) {
        try {
            equipeRepository.deleteById(equipeId);
            return ResponseEntity.ok("Équipe supprimée avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression de l'équipe");
        }
    }

    public List<EquipeDTO> searchEquipesByName(String nomEquipe) {
        return equipeRepository.findByNomEquipeContainingIgnoreCase(nomEquipe)
                .stream()
                .map(EquipeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ResponseEntity<EquipeDTO> updateEquipe(Long equipeId, EquipeDTO equipeDTO) {
        return equipeRepository.findById(equipeId)
                .map(existingEquipe -> {
                    existingEquipe.setNomEquipe(equipeDTO.getNomEquipe());
                    existingEquipe.setAcronyme(equipeDTO.getAcronyme());
                    existingEquipe.setBudget(equipeDTO.getBudget());
                    Equipe updatedEquipe = equipeRepository.save(existingEquipe);
                    return ResponseEntity.ok(EquipeDTO.fromEntity(updatedEquipe));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
