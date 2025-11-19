package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.RubriqueDto;
import com.previsionbudgetaire.mapper.RubriqueMapper;
import com.previsionbudgetaire.model.Rubrique;
import com.previsionbudgetaire.repository.RubriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RubriqueServiceImplem implements RubriqueService {

    @Autowired
    RubriqueRepository rubriqueRepository;

    @Autowired
    RubriqueMapper rubriqueMapper;

    @Override
    public RubriqueDto findById(String id) {
        Rubrique rubrique=rubriqueRepository.findByNumComptable(id);
        RubriqueDto rubriqueDto=rubriqueMapper.fromRubriqueToRubriqueDto(rubrique);


        return rubriqueDto;
    }

    @Override
    public RubriqueDto save(RubriqueDto rubriqueDto) {
        Rubrique rubrique=rubriqueMapper.fromRubriqueDtoToRubrique(rubriqueDto);

        rubrique.setNumComptable(UUID.randomUUID().toString());
        Rubrique rubrique1=rubriqueRepository.save(rubrique);
        System.out.println("iufhi=================="+rubrique1.getNumComptable());
        RubriqueDto rubriqueDto1=rubriqueMapper.fromRubriqueToRubriqueDto(rubrique1);
        System.out.println("iufhi=================="+rubriqueDto1.getNumComptable());


        return rubriqueDto1;
    }

    @Override
    public void deleteById(String id) {
       rubriqueRepository.deleteByNumComptable(id);

    }

    @Override
    public List<RubriqueDto> findAll() {
        List<Rubrique> rubriques=rubriqueRepository.findAll();
        List<RubriqueDto> rubriqueDtos=new ArrayList<>();
        for(Rubrique rubrique:rubriques){
            RubriqueDto rubriqueDto=rubriqueMapper.fromRubriqueToRubriqueDto(rubrique);
            rubriqueDtos.add(rubriqueDto);
        }
        return rubriqueDtos;
    }

    @Override
    public RubriqueDto updateById(RubriqueDto rubriqueDto) {

        Rubrique rubrique=rubriqueMapper.fromRubriqueDtoToRubrique(rubriqueDto);

        Rubrique rubrique1=rubriqueRepository.save(rubrique);
        RubriqueDto rubriqueDto1=rubriqueMapper.fromRubriqueToRubriqueDto(rubrique1);

        return rubriqueDto;    }
}
