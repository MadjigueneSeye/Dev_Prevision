package com.previsionbudgetaire.mapper;

import com.previsionbudgetaire.dto.ExerciceDto;
import com.previsionbudgetaire.model.Exercice;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExerciceMapper {

    public ExerciceDto toDto(Exercice exercice) {
        if (exercice == null) {
            return null;
        }
        
        ExerciceDto dto = new ExerciceDto();
        BeanUtils.copyProperties(exercice, dto);
        return dto;
    }

    public Exercice toEntity(ExerciceDto dto) {
        if (dto == null) {
            return null;
        }
        
        Exercice exercice = new Exercice();
        BeanUtils.copyProperties(dto, exercice);
        

        
        return exercice;
    }


}