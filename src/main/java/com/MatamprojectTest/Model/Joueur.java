package com.MatamprojectTest.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "joueur")
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , name = "nomJoueur")
    private String nomJoueur;

    @Column(nullable = false , name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name="equipe_id", nullable = false)
    private Equipe equipe;
}
