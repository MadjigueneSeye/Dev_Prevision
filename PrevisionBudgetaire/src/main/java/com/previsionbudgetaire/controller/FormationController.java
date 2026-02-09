package com.previsionbudgetaire.controller;


import com.previsionbudgetaire.dto.FormationCreateDTO;
import com.previsionbudgetaire.dto.FormationDTO;
import com.previsionbudgetaire.service.FormationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class FormationController {

    private final FormationService formationService;

    /**
     * GET /api/formations - Récupérer toutes les formations
     */
    @GetMapping
    public ResponseEntity<List<FormationDTO>> getAllFormations() {
        log.info("GET /api/formations - Récupération de toutes les formations");
        List<FormationDTO> formations = formationService.getAllFormations();
        return ResponseEntity.ok(formations);
    }

    /**
     * GET /api/formations/{id} - Récupérer une formation par ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable Long id) {
        log.info("GET /api/formations/{} - Récupération de la formation", id);
        FormationDTO formation = formationService.getFormationById(id);
        return ResponseEntity.ok(formation);
    }

    /**
     * GET /api/formations/departement/{departementId} - Récupérer les formations d'un département
     */
    @GetMapping("/departement/{departementId}")
    public ResponseEntity<List<FormationDTO>> getFormationsByDepartement(@PathVariable Long departementId) {
        log.info("GET /api/formations/departement/{} - Récupération des formations du département", departementId);
        List<FormationDTO> formations = formationService.getFormationsByDepartement(departementId);
        return ResponseEntity.ok(formations);
    }

    /**
     * GET /api/formations/search - Rechercher des formations
     */
    @GetMapping("/search")
    public ResponseEntity<List<FormationDTO>> searchFormations(@RequestParam String keyword) {
        log.info("GET /api/formations/search?keyword={}", keyword);
        List<FormationDTO> formations = formationService.searchFormations(keyword);
        return ResponseEntity.ok(formations);
    }

    /**
     * POST /api/formations - Créer une nouvelle formation
     */
    @PostMapping
    public ResponseEntity<FormationDTO> createFormation(@Valid @RequestBody FormationCreateDTO createDTO) {
        log.info("POST /api/formations - Création d'une nouvelle formation: {}", createDTO.getLibelle());
        FormationDTO formation = formationService.createFormation(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(formation);
    }

    /**
     * PUT /api/formations/{id} - Mettre à jour une formation
     */
    @PutMapping("/{id}")
    public ResponseEntity<FormationDTO> updateFormation(
            @PathVariable Long id,
            @Valid @RequestBody FormationCreateDTO updateDTO) {
        log.info("PUT /api/formations/{} - Mise à jour de la formation", id);
        FormationDTO formation = formationService.updateFormation(id, updateDTO);
        return ResponseEntity.ok(formation);
    }

    /**
     * DELETE /api/formations/{id} - Supprimer une formation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        log.info("DELETE /api/formations/{} - Suppression de la formation", id);
        formationService.deleteFormation(id);
        return ResponseEntity.noContent().build();
    }
}
