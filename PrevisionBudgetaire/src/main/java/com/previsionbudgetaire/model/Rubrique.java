package com.previsionbudgetaire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rubrique {

    @Id
    String numComptable;
    String libelle;

    @OneToMany(mappedBy ="rubrique" )
    List<Prevision>  previsions;

}
