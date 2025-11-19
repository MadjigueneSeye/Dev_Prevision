package com.previsionbudgetaire.mapper;

import com.previsionbudgetaire.dto.RubriqueDto;
import com.previsionbudgetaire.model.Rubrique;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class RubriqueMapper {

    public RubriqueDto fromRubriqueToRubriqueDto(Rubrique rubrique){
        RubriqueDto rubriqueDto = new RubriqueDto();
        BeanUtils.copyProperties(rubrique,rubriqueDto);
        return rubriqueDto;
    }

    public Rubrique fromRubriqueDtoToRubrique(RubriqueDto rubriqueDto){
        Rubrique rubrique = new Rubrique();
        BeanUtils.copyProperties(rubriqueDto,rubrique);
        return rubrique;
    }
}
