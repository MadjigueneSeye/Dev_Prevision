package com.previsionbudgetaire.controller;

import com.previsionbudgetaire.dto.ExerciceDto;
import com.previsionbudgetaire.service.ExerciceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercices")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class ExerciceController {

    private final ExerciceService exerciceService;

    @GetMapping
    public ResponseEntity<List<ExerciceDto>> getAllExercices() {
        log.info("GET /api/exercices - Récupération de tous les exercices");
        List<ExerciceDto> exercices = exerciceService.getAllExercices();
        return ResponseEntity.ok(exercices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciceDto> getExerciceById(@PathVariable Long id) {
        log.info("GET /api/exercices/{} - Récupération de l'exercice", id);
        ExerciceDto exercice = exerciceService.getExerciceById(id);
        return ResponseEntity.ok(exercice);
    }





    @PostMapping
    public ResponseEntity<ExerciceDto> createExercice(@RequestBody ExerciceDto exerciceDto) {
        log.info("POST /api/exercices - Création d'un nouvel exercice: {}", exerciceDto.getLibelle());
        ExerciceDto createdExercice = exerciceService.createExercice(exerciceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExercice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciceDto> updateExercice(
            @PathVariable Long id,
            @RequestBody ExerciceDto exerciceDto) {
        log.info("PUT /api/exercices/{} - Mise à jour de l'exercice", id);
        ExerciceDto updatedExercice = exerciceService.updateExercice( exerciceDto);
        return ResponseEntity.ok(updatedExercice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercice(@PathVariable Long id) {
        log.info("DELETE /api/exercices/{} - Suppression de l'exercice", id);
        exerciceService.deleteExercice(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/exists/{libelle}")
    public ResponseEntity<Boolean> existsByLibelle(@PathVariable String libelle) {
        log.info("GET /api/exercices/exists/{} - Vérification de l'existence", libelle);
        boolean exists = exerciceService.existsByLibelle(libelle);
        return ResponseEntity.ok(exists);
    }
}