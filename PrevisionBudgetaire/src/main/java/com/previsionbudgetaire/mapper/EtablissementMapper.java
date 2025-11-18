package com.previsionbudgetaire.mapper;

import com.previsionbudgetaire.dto.EtablissementDto;
import com.previsionbudgetaire.model.Etablissement;
import org.springframework.stereotype.Component;

@Component
public class EtablissementMapper {


    public EtablissementDto toDto(Etablissement etablissement) {
        if (etablissement == null) {
            return null;
        }

        EtablissementDto dto = new EtablissementDto();
        dto.setId(etablissement.getId());
        dto.setIntitule(etablissement.getIntitule());
        dto.setSigle(etablissement.getSigle());
        dto.setTypeEtablissement(etablissement.getTypeEtablissement());

        return dto;
    }


    public Etablissement toEntity(EtablissementDto dto) {
        if (dto == null) {
            return null;
        }

        Etablissement etablissement = new Etablissement();
        etablissement.setId(dto.getId());
        etablissement.setIntitule(dto.getIntitule());
        etablissement.setSigle(dto.getSigle());
        etablissement.setTypeEtablissement(dto.getTypeEtablissement());

        return etablissement;
    }

    public void updateEntityFromDto(EtablissementDto dto, Etablissement etablissement) {
        if (dto == null || etablissement == null) {
            return;
        }

        etablissement.setIntitule(dto.getIntitule());
        etablissement.setSigle(dto.getSigle());
        etablissement.setTypeEtablissement(dto.getTypeEtablissement());
    }
}
