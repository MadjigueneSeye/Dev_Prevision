package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.PrevisionDto;
import com.previsionbudgetaire.mapper.PrevisionMapper;
import com.previsionbudgetaire.model.Prevision;
import com.previsionbudgetaire.repository.PrevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PrevisionServiceImpl implements PrevisionService {

    @Autowired
    PrevisionRepository previsionRepository;

    @Autowired
    PrevisionMapper previsionMapper;

    @Override
    public List<PrevisionDto> findAll() {
        List<Prevision> previsions = previsionRepository.findAll();
        List<PrevisionDto> previsionDtos = new ArrayList<>();
        for(Prevision p : previsions){
            PrevisionDto previsionDto=previsionMapper.fromPrevision(p);
            previsionDtos.add(previsionDto);
        }
        return previsionDtos;
    }

    @Override
    public PrevisionDto findById(long id) {
        Prevision p=previsionRepository.findById(id).get();
        PrevisionDto previsionDto=previsionMapper.fromPrevision(p);
        return previsionDto;
    }

    @Override
    public PrevisionDto save(PrevisionDto previsionDto) {
        Prevision p=previsionMapper.fromPrevisionDto(previsionDto);
        Prevision prevision=previsionRepository.save(p);

        return previsionMapper.fromPrevision(prevision);
    }

    @Override
    public void deleteById(long id) {
        previsionRepository.deleteById(id);
    }

    @Override
    public List<PrevisionDto> findAllByEtablissementId(long id) {
        List<Prevision> previsions=previsionRepository.findAllByEtablissementId(id);
        List<PrevisionDto> previsionDtos=new ArrayList<>();
        for(Prevision p : previsions){
            PrevisionDto previsionDto=previsionMapper.fromPrevision(p);
            previsionDtos.add(previsionDto);

        }
        return previsionDtos;
    }
}