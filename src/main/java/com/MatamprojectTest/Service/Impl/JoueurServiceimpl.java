package com.MatamprojectTest.Service.Impl;

import com.MatamprojectTest.DTO.EquipeDTO;
import com.MatamprojectTest.DTO.JoueurDTO;
import com.MatamprojectTest.Model.Joueur;
import com.MatamprojectTest.Repository.JoueurRepository;
import com.MatamprojectTest.Service.JoueurService;
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
public class JoueurServiceimpl implements JoueurService {

    @Autowired
    private JoueurRepository joueurRepository;

    private EquipeDTO equipeDTO;

    public ResponseEntity<String> addJoueur(JoueurDTO joueurDTO) {
        try {
            Joueur joueur = JoueurDTO.toEntity(joueurDTO);
            Joueur savedJoueur = joueurRepository.save(joueur);
            return ResponseEntity.status(HttpStatus.CREATED).body("Joueur ajouté avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du joueur");
        }
    }

    public Page<JoueurDTO> getAllJoueurs(Pageable pageable) {
        return joueurRepository.findAll(pageable).map(JoueurDTO::fromEntity);
    }

    public JoueurDTO getJoueurById(Long id) {
        Optional<Joueur> joueurOptional = joueurRepository.findById(id);
        return joueurOptional.map(JoueurDTO::fromEntity).orElse(null);
    }

    public ResponseEntity<String> deleteJoueur(Long joueurId) {
        try {
            joueurRepository.deleteById(joueurId);
            return ResponseEntity.ok("Joueur supprimé avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression du joueur");
        }
    }

    public Page<JoueurDTO> searchJoueursByEquipeName(String nomEquipe, Pageable pageable) {
        return joueurRepository.findByEquipeNomEquipeContainingIgnoreCase(nomEquipe, pageable).map(JoueurDTO::fromEntity);
    }

    //Update Infos Joueurs
    public ResponseEntity<JoueurDTO> updateJoueur(Long joueurId, JoueurDTO joueurDTO) {
        return joueurRepository.findById(joueurId)
                .map(existingJoueur -> {
                    existingJoueur.setNomJoueur(joueurDTO.getNom());
                    existingJoueur.setPosition(joueurDTO.getPosition());
                    existingJoueur.setEquipe(EquipeDTO.toEntity(joueurDTO.getEquipe()));
                    Joueur updatedJoueur = joueurRepository.save(existingJoueur);
                    return ResponseEntity.ok(JoueurDTO.fromEntity(updatedJoueur));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public List<JoueurDTO> getJoueursByEquipe(Long equipeId) {
        return joueurRepository.findByEquipeId(equipeId)
                .stream()
                .map(JoueurDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
