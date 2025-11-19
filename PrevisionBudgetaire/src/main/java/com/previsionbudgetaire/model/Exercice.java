package com.previsionbudgetaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "exercice", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Prevision> previsions = new ArrayList<>();

}