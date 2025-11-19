package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.PrevisionDto;
import com.previsionbudgetaire.model.Prevision;

import java.util.List;

public interface PrevisionService
{
    public List<PrevisionDto> findAll();
    public PrevisionDto findById(long id);
    public PrevisionDto save(PrevisionDto previsionDto);
    public void deleteById(long id);
    public List<PrevisionDto> findAllByEtablissementId(long id);
}
