package com.previsionbudgetaire.mapper;

import com.previsionbudgetaire.dto.ExerciceDto;
import com.previsionbudgetaire.dto.PrevisionDto;
import com.previsionbudgetaire.dto.RubriqueDto;
import com.previsionbudgetaire.model.Prevision;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrevisionMapper {

    @Autowired
    EtablissementMapper etablissementMapper;

    @Autowired
    ExerciceMapper  exerciceMapper;

    @Autowired
    RubriqueMapper rubriqueMapper;

    public PrevisionDto fromPrevision(Prevision prevision){
        PrevisionDto previsionDto = new PrevisionDto();
        BeanUtils.copyProperties(prevision,previsionDto);
        previsionDto.setEtablissementDto(etablissementMapper.toDto(prevision.getEtablissement()));
        previsionDto.setExerciceDto(exerciceMapper.toDto(prevision.getExercice()));
        previsionDto.setRubriqueDto(rubriqueMapper.fromRubriqueToRubriqueDto(prevision.getRubrique()));
        return previsionDto;
    }

    public Prevision fromPrevisionDto(PrevisionDto previsionDto){
        Prevision prevision = new Prevision();

        BeanUtils.copyProperties(previsionDto,prevision);
        prevision.setEtablissement(etablissementMapper.toEntity(previsionDto.getEtablissementDto()));
        prevision.setExercice(exerciceMapper.toEntity(previsionDto.getExerciceDto()));
        prevision.setRubrique(rubriqueMapper.fromRubriqueDtoToRubrique(previsionDto.getRubriqueDto()));
        return prevision;
    }
}
