package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.DepartementDto;
import com.previsionbudgetaire.mapper.DepartementMapper;
import com.previsionbudgetaire.model.Departement;
import com.previsionbudgetaire.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartementServiceImple implements DepartementService {

    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    DepartementMapper departementMapper;

    @Override
    public List<DepartementDto> getDepartements() {
        List<Departement> departements = departementRepository.findAll();
        List<DepartementDto> departementDtos = new ArrayList<>();
        for (Departement departement : departements) {
            DepartementDto departementDto = new DepartementDto();
            departementDto=departementMapper.fromDepartementToDepartementDto(departement);
            departementDtos.add(departementDto);
        }
        return departementDtos;
    }

    @Override
    public DepartementDto getDepartementById(Long id) {
        Departement departement = departementRepository.findById(id).orElse(null);
        return departementMapper.fromDepartementToDepartementDto(departement);
    }

    @Override
    public DepartementDto saveDepartement(DepartementDto departementDto) {

        Departement departement=departementMapper.fromDepartementDtoToDepartement(departementDto);
        Departement departement1=departementRepository.save(departement);
        return departementMapper.fromDepartementToDepartementDto(departement1);
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

    @Override
    public List<DepartementDto> getDepartementsByEtablissement(Long id) {
//        List<Departement> departements=departementRepository.findAllByEtablissement(id);
//        List<DepartementDto> departementDtos = new ArrayList<>();
//        for (Departement departement : departements) {
//            DepartementDto departementDto = new DepartementDto();
//            departementDto=departementMapper.fromDepartementToDepartementDto(departement);
//            departementDtos.add(departementDto);
//        }
        return null;
    }

    @Override
    public DepartementDto modifierDepartement(DepartementDto departementDto) {
        Departement departement=departementMapper.fromDepartementDtoToDepartement(departementDto);
        departement=departementRepository.save(departement);

        return departementMapper.fromDepartementToDepartementDto(departement);
    }
}
