package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.ExerciceDto;
import com.previsionbudgetaire.exception.DuplicateResourceException;
import com.previsionbudgetaire.exception.ResourceNotFoundException;
import com.previsionbudgetaire.mapper.ExerciceMapper;
import com.previsionbudgetaire.model.Exercice;
import com.previsionbudgetaire.repository.ExerciceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ExerciceServiceImpl implements ExerciceService {

    private final ExerciceRepository exerciceRepository;
    private final ExerciceMapper exerciceMapper;

    @Override
    public List<ExerciceDto> getAllExercices() {
        return exerciceRepository.findAll()
                .stream()
                .map(exerciceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExerciceDto getExerciceById(Long id) {
        Exercice exercice = exerciceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercice non trouvé avec l'ID: " + id));
        return exerciceMapper.toDto(exercice);
    }



    @Override
    public ExerciceDto createExercice(ExerciceDto exerciceDto) {
        log.info("Création d'un nouvel exercice: {}", exerciceDto.getLibelle());

        if (exerciceRepository.existsByLibelleIgnoreCase(exerciceDto.getLibelle())) {
            throw new DuplicateResourceException("Un exercice avec le libellé '" + exerciceDto.getLibelle() + "' existe déjà");
        }

        Exercice exercice = exerciceMapper.toEntity(exerciceDto);
        Exercice savedExercice = exerciceRepository.save(exercice);
        
        log.info("Exercice créé avec succès avec l'ID: {}", savedExercice.getId());
        return exerciceMapper.toDto(savedExercice);
    }

    @Override
    public ExerciceDto updateExercice(ExerciceDto exerciceDto) {



        Exercice exercice = exerciceMapper.toEntity(exerciceDto);
        Exercice savedExercice = exerciceRepository.save(exercice);

        return exerciceMapper.toDto(savedExercice);
    }

    @Override
    public void deleteExercice(Long id) {
        log.info("Suppression de l'exercice avec l'ID: {}", id);

        if (!exerciceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Exercice non trouvé avec l'ID: " + id);
        }

        exerciceRepository.deleteById(id);
        log.info("Exercice supprimé avec succès");
    }


    @Override
    public boolean existsByLibelle(String libelle) {
        return exerciceRepository.existsByLibelleIgnoreCase(libelle);
    }


}