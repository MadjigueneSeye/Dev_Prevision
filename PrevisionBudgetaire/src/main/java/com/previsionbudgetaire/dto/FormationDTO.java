package com.previsionbudgetaire.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationDTO {

    private Long id;

    private String libelle;

    private Long departementId;

    private String departementLibelle; // Pour l'affichage
}