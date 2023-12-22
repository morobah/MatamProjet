package com.MatamprojectTest.Controller;

import com.MatamprojectTest.DTO.JoueurDTO;
import com.MatamprojectTest.Service.Impl.JoueurServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurController {

    @Autowired
    private JoueurServiceimpl joueurService;

    @PostMapping
    public ResponseEntity<String> addJoueur(@RequestBody JoueurDTO joueurDTO) {
        return joueurService.addJoueur(joueurDTO);
    }

    @GetMapping
    public Page<JoueurDTO> getAllJoueurs(Pageable pageable) {
        return joueurService.getAllJoueurs(pageable);
    }

    @GetMapping("/{id}")
    public JoueurDTO getJoueurById(@PathVariable Long id) {
        return joueurService.getJoueurById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJoueur(@PathVariable Long id) {
        return joueurService.deleteJoueur(id);
    }

    @GetMapping("/equipe/{equipeId}")
    public List<JoueurDTO> getJoueursByEquipe(@PathVariable Long equipeId) {
        return joueurService.getJoueursByEquipe(equipeId);
    }

    @GetMapping("/search")
    public Page<JoueurDTO> searchJoueursByEquipeName(@RequestParam String nomEquipe, Pageable pageable) {
        return joueurService.searchJoueursByEquipeName(nomEquipe, pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JoueurDTO> updateJoueur(@PathVariable Long id, @RequestBody JoueurDTO joueurDTO) {
        return joueurService.updateJoueur(id, joueurDTO);
    }
}
