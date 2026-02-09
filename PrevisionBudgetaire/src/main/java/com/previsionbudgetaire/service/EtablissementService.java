package com.previsionbudgetaire.service;

import com.previsionbudgetaire.dto.EtablissementDto;
import com.previsionbudgetaire.enumeration.TypeEtablissement;
import com.previsionbudgetaire.exception.DuplicateResourceException;
import com.previsionbudgetaire.exception.ResourceNotFoundException;
import com.previsionbudgetaire.mapper.EtablissementMapper;
import com.previsionbudgetaire.repository.EtablissementRepository;
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
public class EtablissementService {


    private final EtablissementRepository etablissementRepository;
    private final EtablissementMapper etablissementMapper;

@Transactional
    public EtablissementDto create(EtablissementDto dto) {
        log.info("Création d'un établissement : {}", dto.getIntitule());

        // Vérifier si le sigle existe déjà
        if (etablissementRepository.existsBySigle(dto.getSigle())) {
            throw new DuplicateResourceException("Un établissement avec le sigle '" + dto.getSigle() + "' existe déjà");
        }

        com.previsionbudgetaire.model.Etablissement etablissement = etablissementMapper.toEntity(dto);
        com.previsionbudgetaire.model.Etablissement saved = etablissementRepository.save(etablissement);

        log.info("Établissement créé avec succès, ID: {}", saved.getId());
        return etablissementMapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public List<EtablissementDto> findAll() {
        log.info("Récupération de tous les établissements");
        return etablissementRepository.findAll()
                .stream()
                .map(etablissementMapper::toDto)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public EtablissementDto findById(Long id) {
        log.info("Récupération de l'établissement avec l'ID: {}", id);
        com.previsionbudgetaire.model.Etablissement etablissement = etablissementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Établissement non trouvé avec l'ID: " + id));
        return etablissementMapper.toDto(etablissement);
    }

    public EtablissementDto update(Long id, EtablissementDto dto) {
        log.info("Mise à jour de l'établissement avec l'ID: {}", id);

        com.previsionbudgetaire.model.Etablissement etablissement = etablissementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Établissement non trouvé avec l'ID: " + id));

        // Vérifier si le nouveau sigle n'est pas déjà utilisé par un autre établissement
        if (!etablissement.getSigle().equals(dto.getSigle()) &&
                etablissementRepository.existsBySigle(dto.getSigle())) {
            throw new DuplicateResourceException("Un établissement avec le sigle '" + dto.getSigle() + "' existe déjà");
        }

        etablissementMapper.updateEntityFromDto(dto, etablissement);
        com.previsionbudgetaire.model.Etablissement updated = etablissementRepository.save(etablissement);

        log.info("Établissement mis à jour avec succès, ID: {}", updated.getId());
        return etablissementMapper.toDto(updated);
    }

    public void delete(Long id) {
        log.info("Suppression de l'établissement avec l'ID: {}", id);

        if (!etablissementRepository.existsById(id)) {
            throw new ResourceNotFoundException("Établissement non trouvé avec l'ID: " + id);
        }

        etablissementRepository.deleteById(id);
        log.info("Établissement supprimé avec succès, ID: {}", id);
    }

    @Transactional(readOnly = true)
    public List<EtablissementDto> findByType(TypeEtablissement type) {
        log.info("Recherche d'établissements par type: {}", type);
        return etablissementRepository.findByTypeEtablissement(type)
                .stream()
                .map(etablissementMapper::toDto)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<EtablissementDto> searchByIntitule(String intitule) {
        log.info("Recherche d'établissements par intitulé: {}", intitule);
        return etablissementRepository.findByIntituleContainingIgnoreCase(intitule)
                .stream()
                .map(etablissementMapper::toDto)
                .collect(Collectors.toList());
    }
}
