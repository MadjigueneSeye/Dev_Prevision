package com.previsionbudgetaire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prevision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double montantAllouer;

    @ManyToOne
    Etablissement etablissement;

    @ManyToOne
    Exercice exercice;
    @ManyToOne
    Rubrique rubrique;


}
