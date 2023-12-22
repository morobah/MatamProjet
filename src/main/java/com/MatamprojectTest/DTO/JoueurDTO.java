package com.MatamprojectTest.DTO;

import com.MatamprojectTest.Model.Joueur;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JoueurDTO {

    private Long id;
    private String nom;
    private String position;
    private EquipeDTO equipe;

    public static JoueurDTO fromEntity(Joueur joueur) {
        if (joueur == null) {
            return null;
        }
        return JoueurDTO.builder()
                .id(joueur.getId())
                .nom(joueur.getNomJoueur())
                .position(joueur.getPosition())
                .equipe(EquipeDTO.fromEntity(joueur.getEquipe()))
                .build();
    }

    public static Joueur toEntity (JoueurDTO joueurDTO){
        if (joueurDTO == null) {
            return null;
        }
        Joueur joueur = new Joueur();
        joueur.setId(joueurDTO.getId());
        joueur.setNomJoueur(joueur.getNomJoueur());
        joueur.setPosition(joueur.getPosition());
        joueur.setEquipe(EquipeDTO.toEntity(joueurDTO.getEquipe()));

        return joueur;
    }
}
