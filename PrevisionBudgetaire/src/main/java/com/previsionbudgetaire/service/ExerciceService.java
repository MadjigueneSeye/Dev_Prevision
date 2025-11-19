package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.ExerciceDto;

import java.util.List;

public interface ExerciceService {

    List<ExerciceDto> getAllExercices();

    ExerciceDto getExerciceById(Long id);


    ExerciceDto createExercice(ExerciceDto exerciceDto);

    ExerciceDto updateExercice(ExerciceDto exerciceDto);

    void deleteExercice(Long id);


    boolean existsByLibelle(String libelle);
}