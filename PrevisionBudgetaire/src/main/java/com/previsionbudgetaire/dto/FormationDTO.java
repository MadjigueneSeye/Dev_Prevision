package com.previsionbudgetaire.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationDTO {

    private Long id;

    @NotBlank(message = "Le libellé de la formation est obligatoire")
    @Size(min = 3, max = 200, message = "Le libellé doit contenir entre 3 et 200 caractères")
    private String libelle;

    @NotNull(message = "Le département est obligatoire")
    private Long departementId;

    private String departementLibelle; // Pour l'affichage
}