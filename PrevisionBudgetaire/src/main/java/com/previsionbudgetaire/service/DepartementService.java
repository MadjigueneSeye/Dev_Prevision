package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.DepartementDto;
import com.previsionbudgetaire.model.Departement;

import java.util.List;

public interface DepartementService {

    public List<DepartementDto> getDepartements();
    public DepartementDto getDepartementById(Long id);
    public DepartementDto saveDepartement(DepartementDto departementDto);
    public void deleteDepartement(Long id);
    public List<DepartementDto> getDepartementsByEtablissement(Long id);
    public DepartementDto modifierDepartement(DepartementDto departementDto);

}
