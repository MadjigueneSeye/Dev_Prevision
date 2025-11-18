package com.previsionbudgetaire.dto;

import com.previsionbudgetaire.model.Departement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationDTO {

    private Long id;

    private String libelle;

    private Departement departement; // Pour l'affichage
}