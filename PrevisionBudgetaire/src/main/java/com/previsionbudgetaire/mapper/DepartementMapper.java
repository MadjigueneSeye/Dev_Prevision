package com.previsionbudgetaire.mapper;

import com.previsionbudgetaire.dto.DepartementDto;
import com.previsionbudgetaire.model.Departement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DepartementMapper {

    public DepartementDto fromDepartementToDepartementDto(Departement departement){

        DepartementDto departementDto = new DepartementDto();
        BeanUtils.copyProperties(departement,departementDto);
        return departementDto;

    }

    public Departement fromDepartementDtoToDepartement(DepartementDto departementDto){

        Departement departement = new Departement();
        BeanUtils.copyProperties(departementDto,departement);
        return departement;
    }
}
