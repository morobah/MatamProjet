package com.MatamprojectTest.Controller;

import com.MatamprojectTest.DTO.EquipeDTO;
import com.MatamprojectTest.Service.Impl.EquipeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    @Autowired
    private EquipeServiceimpl equipeService;

    @PostMapping
    public ResponseEntity<String> addEquipe(@RequestBody EquipeDTO equipeDTO) {
        return equipeService.addEquipe(equipeDTO);
    }

    @GetMapping
    public Page<EquipeDTO> getAllEquipes(Pageable pageable) {
        return equipeService.getAllEquipes(pageable);
    }

    @GetMapping("/{id}")
    public EquipeDTO getEquipeById(@PathVariable Long id) {
        return equipeService.getEquipeById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEquipe(@PathVariable Long id) {
        return equipeService.deleteEquipe(id);
    }

    @GetMapping("/search")
    public List<EquipeDTO> searchEquipesByName(@RequestParam String nomEquipe) {
        return equipeService.searchEquipesByName(nomEquipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipeDTO> updateEquipe(@PathVariable Long id, @RequestBody EquipeDTO equipeDTO) {
        return equipeService.updateEquipe(id, equipeDTO);
    }
}
