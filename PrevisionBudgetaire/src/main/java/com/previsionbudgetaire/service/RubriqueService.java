package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.RubriqueDto;
import com.previsionbudgetaire.model.Rubrique;

import java.util.List;

public interface RubriqueService {
    public RubriqueDto findById(String id);
    public RubriqueDto save(RubriqueDto rubriqueDto);
    public void deleteById(String id);
    public List<RubriqueDto> findAll();
    public RubriqueDto updateById(RubriqueDto rubriqueDto);
}
