package com.previsionbudgetaire.dto;

import com.previsionbudgetaire.enumeration.TypeEtablissement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementDto {

    private Long id;

    private String intitule;

    private String sigle;

    private TypeEtablissement typeEtablissement;
}