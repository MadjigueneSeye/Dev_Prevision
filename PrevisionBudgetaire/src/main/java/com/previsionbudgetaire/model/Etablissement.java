package com.previsionbudgetaire.model;

import com.previsionbudgetaire.enumeration.TypeEtablissement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "etablissement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;

    private String sigle;

    @Enumerated(EnumType.STRING)

    private TypeEtablissement typeEtablissement;

   @OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Departement> departements = new ArrayList<>();

//    @OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Prevision> previsions = new ArrayList<>();
}