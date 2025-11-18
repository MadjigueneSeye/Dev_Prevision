package com.previsionbudgetaire.mapper;

import com.previsionbudgetaire.dto.FormationCreateDTO;
import com.previsionbudgetaire.dto.FormationDTO;
import com.previsionbudgetaire.model.Formation;
import com.ucad.comptabilite.model.Departement;
import org.springframework.stereotype.Component;

@Component
public class FormationMapper {

    public FormationDTO toDTO(Formation formation) {
        if (formation == null) {
            return null;
        }

        FormationDTO dto = new FormationDTO();
        dto.setId(formation.getId());
        dto.setLibelle(formation.getLibelle());

        if (formation.getDepartement() != null) {
            dto.setDepartementId(formation.getDepartement().getId());
            dto.setDepartementLibelle(formation.getDepartement().getLibelle());
        }

        return dto;
    }

    public Formation toEntity(FormationCreateDTO dto, Departement departement) {
        if (dto == null) {
            return null;
        }

        Formation formation = new Formation();
        formation.setLibelle(dto.getLibelle());
        formation.setDepartement(departement);

        return formation;
    }

    public void updateEntity(Formation formation, FormationCreateDTO dto, Departement departement) {
        if (formation == null || dto == null) {
            return;
        }

        formation.setLibelle(dto.getLibelle());
        formation.setDepartement(departement);
    }
}
