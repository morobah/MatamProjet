package com.MatamprojectTest.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "NomEquipe")
    private  String NomEquipe;

    @Column(nullable = false , name = "acronyme")
    private String acronyme;

    @Column(nullable = false , name = "budget")
    private double budget;

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    private List<Joueur> joueurs;

}
