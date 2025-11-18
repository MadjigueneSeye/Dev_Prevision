package com.previsionbudgetaire.mapper;

import com.previsionbudgetaire.dto.FormationDTO;
import com.previsionbudgetaire.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FormationMapper {

    public FormationDTO toDTO(Formation formation) {
        FormationDTO formationDTO = new FormationDTO();
        BeanUtils.copyProperties(formation, formationDTO);

        return formationDTO;
    }

    public Formation toEntity(FormationDTO dto) {
        Formation  formation = new Formation();
        BeanUtils.copyProperties(dto, formation);
        return formation;
    }

//    public void updateEntity(Formation formation, FormationCreateDTO dto, Departement departement) {
//        if (formation == null || dto == null) {
//            return;
//        }
//
//        formation.setLibelle(dto.getLibelle());
//        formation.setDepartement(departement);
//    }
}
