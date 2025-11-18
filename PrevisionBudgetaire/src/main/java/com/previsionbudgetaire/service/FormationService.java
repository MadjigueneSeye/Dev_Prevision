package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.FormationDTO;
import com.previsionbudgetaire.exception.ResourceNotFoundException;
import com.previsionbudgetaire.mapper.FormationMapper;
import com.previsionbudgetaire.model.Formation;
import com.previsionbudgetaire.repository.DepartementRepository;
import com.previsionbudgetaire.repository.FormationRepository;
import com.previsionbudgetaire.exception.DuplicateResourceException; 
import com.previsionbudgetaire.model.Departement; 



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class FormationService {

    private final FormationRepository formationRepository;
    private final DepartementRepository departementRepository;
    private final FormationMapper formationMapper;

    /**
     * Récupérer toutes les formations
     */
    public List<FormationDTO> getAllFormations() {
        List<Formation> formations = formationRepository.findAll();
        List<FormationDTO> formationDTOS = formations.stream().map(formationMapper::toDTO).collect(Collectors.toList());
        return formationDTOS;
    }

    /**
     * Récupérer une formation par son ID
     */
    public FormationDTO getFormationById(Long id) {
       Formation formation = formationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Formation"));
       FormationDTO formationDTO = formationMapper.toDTO(formation);
       return formationDTO;
    }

    /**
     * Récupérer les formations d'un département
     */
    public List<FormationDTO> getFormationsByDepartement(Long departementId) {
       List<Formation> formations = formationRepository.findByDepartementId(departementId);
       List<FormationDTO> formationDTOS = formations.stream().map(formationMapper::toDTO).collect(Collectors.toList());
       return formationDTOS;
    }

    /**
     * Créer une nouvelle formation
     */
    @Transactional
    public FormationDTO createFormation(FormationDTO createDTO) {
        Formation formation = formationMapper.toEntity(createDTO);
        formation = formationRepository.save(formation);
        FormationDTO formationDTO = formationMapper.toDTO(formation);
        return formationDTO;
    }

    /**
     * Mettre à jour une formation
     */
    @Transactional
    public FormationDTO updateFormation( FormationDTO updateDTO) {
        Formation formation = formationMapper.toEntity(updateDTO);
        formation = formationRepository.save(formation);
        FormationDTO formationDTO = formationMapper.toDTO(formation);
        return formationDTO;
    }

    /**
     * Supprimer une formation
     */
    @Transactional
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }

    /**
     * Rechercher des formations par libellé
     */
    public List<FormationDTO> searchFormations(String keyword) {
      List<Formation> formations=formationRepository.searchByLibelle(keyword);
      List<FormationDTO> formationDTOS = formations.stream().map(formationMapper::toDTO).collect(Collectors.toList());
      return formationDTOS;
    }
}
