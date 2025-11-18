package com.previsionbudgetaire.dto;

import com.previsionbudgetaire.model.Etablissement;

import lombok.Data;

@Data
public class DepartementDto {

    Long id;
    String libelle;

    Etablissement etablissement;
}
