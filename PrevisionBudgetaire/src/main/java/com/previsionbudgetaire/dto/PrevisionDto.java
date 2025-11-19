package com.previsionbudgetaire.dto;

import com.previsionbudgetaire.model.Etablissement;
import com.previsionbudgetaire.model.Exercice;
import com.previsionbudgetaire.model.Rubrique;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PrevisionDto {

    Long id;
    double montantAllouer;
    EtablissementDto etablissementDto;
    ExerciceDto exerciceDto;
    RubriqueDto rubriqueDto;
}
