package com.previsionbudgetaire.service;



import com.previsionbudgetaire.dto.FormationCreateDTO;
import com.previsionbudgetaire.dto.FormationDTO;
import com.previsionbudgetaire.exception.ResourceNotFoundException;
import com.previsionbudgetaire.mapper.FormationMapper;
import com.previsionbudgetaire.model.Formation;
import com.previsionbudgetaire.repository.FormationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class FormationService {

    private final FormationRepository formationRepository;
    private final DepartementRepository departementRepository;
    private final FormationMapper formationMapper;

    /**
     * Récupérer toutes les formations
     */
    public List<FormationDTO> getAllFormations() {
        log.debug("Récupération de toutes les formations");
        return formationRepository.findAllWithDepartement()
                .stream()
                .map(formationMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Récupérer une formation par son ID
     */
    public FormationDTO getFormationById(Long id) {
        log.debug("Récupération de la formation avec l'ID: {}", id);
        Formation formation = formationRepository.findByIdWithDepartement(id)
                .orElseThrow(() -> new ResourceNotFoundException("Formation non trouvée avec l'ID: " + id));
        return formationMapper.toDTO(formation);
    }

    /**
     * Récupérer les formations d'un département
     */
    public List<FormationDTO> getFormationsByDepartement(Long departementId) {
        log.debug("Récupération des formations du département: {}", departementId);

        // Vérifier que le département existe
        if (!departementRepository.existsById(departementId)) {
            throw new ResourceNotFoundException("Département non trouvé avec l'ID: " + departementId);
        }

        return formationRepository.findByDepartementId(departementId)
                .stream()
                .map(formationMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Créer une nouvelle formation
     */
    @Transactional
    public FormationDTO createFormation(FormationCreateDTO createDTO) {
        log.debug("Création d'une nouvelle formation: {}", createDTO.getLibelle());

        // Vérifier que le département existe
        Departement departement = departementRepository.findById(createDTO.getDepartementId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Département non trouvé avec l'ID: " + createDTO.getDepartementId()));

        // Vérifier l'unicité du libellé dans le département
        if (formationRepository.existsByLibelleIgnoreCaseAndDepartementId(
                createDTO.getLibelle(), createDTO.getDepartementId())) {
            throw new DuplicateResourceException(
                    "Une formation avec ce libellé existe déjà dans ce département");
        }

        Formation formation = formationMapper.toEntity(createDTO, departement);
        Formation savedFormation = formationRepository.save(formation);

        log.info("Formation créée avec succès avec l'ID: {}", savedFormation.getId());
        return formationMapper.toDTO(savedFormation);
    }

    /**
     * Mettre à jour une formation
     */
    @Transactional
    public FormationDTO updateFormation(Long id, FormationCreateDTO updateDTO) {
        log.debug("Mise à jour de la formation avec l'ID: {}", id);

        // Récupérer la formation existante
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Formation non trouvée avec l'ID: " + id));

        // Vérifier que le département existe
        Departement departement = departementRepository.findById(updateDTO.getDepartementId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Département non trouvé avec l'ID: " + updateDTO.getDepartementId()));

        // Vérifier l'unicité du libellé (en excluant la formation actuelle)
        formationRepository.findByLibelleIgnoreCase(updateDTO.getLibelle())
                .ifPresent(existingFormation -> {
                    if (!existingFormation.getId().equals(id) &&
                            existingFormation.getDepartement().getId().equals(updateDTO.getDepartementId())) {
                        throw new DuplicateResourceException(
                                "Une formation avec ce libellé existe déjà dans ce département");
                    }
                });

        formationMapper.updateEntity(formation, updateDTO, departement);
        Formation updatedFormation = formationRepository.save(formation);

        log.info("Formation mise à jour avec succès avec l'ID: {}", id);
        return formationMapper.toDTO(updatedFormation);
    }

    /**
     * Supprimer une formation
     */
    @Transactional
    public void deleteFormation(Long id) {
        log.debug("Suppression de la formation avec l'ID: {}", id);

        if (!formationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Formation non trouvée avec l'ID: " + id);
        }

        formationRepository.deleteById(id);
        log.info("Formation supprimée avec succès avec l'ID: {}", id);
    }

    /**
     * Rechercher des formations par libellé
     */
    public List<FormationDTO> searchFormations(String keyword) {
        log.debug("Recherche de formations avec le mot-clé: {}", keyword);
        return formationRepository.searchByLibelle(keyword)
                .stream()
                .map(formationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
