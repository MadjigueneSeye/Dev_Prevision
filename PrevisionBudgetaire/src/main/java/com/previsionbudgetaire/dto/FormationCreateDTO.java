package com.previsionbudgetaire.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationCreateDTO {

    private String libelle;

    private Long departementId;
}
