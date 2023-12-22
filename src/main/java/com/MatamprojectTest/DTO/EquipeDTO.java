package com.MatamprojectTest.DTO;

import com.MatamprojectTest.Model.Equipe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Builder
@Data
public class EquipeDTO {

    private Long id;
    private String nomEquipe;
    private String acronyme;
    private double budget;

    @JsonIgnore
    private List<JoueurDTO> joueurs;

    public static EquipeDTO fromEntity(Equipe equipe) {
        if (equipe == null) {
            return null;
        }
        return EquipeDTO.builder()
                .id(equipe.getId())
                .nomEquipe(equipe.getNomEquipe())
                .acronyme(equipe.getAcronyme())
                .budget(equipe.getBudget())
                .build();
        }
    public static Equipe toEntity (EquipeDTO equipeDTO) {
        if (equipeDTO == null) {
            return null;
        }
        Equipe equipe = new Equipe();
        equipe.setId(equipeDTO.getId());
        equipe.setNomEquipe(equipeDTO.getNomEquipe());
        equipe.setAcronyme(equipeDTO.getAcronyme());
        equipe.setBudget(equipeDTO.getBudget());
        return equipe;
    }
}

