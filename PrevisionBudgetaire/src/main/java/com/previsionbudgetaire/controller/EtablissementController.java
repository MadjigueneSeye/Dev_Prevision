package com.previsionbudgetaire.controller;
import com.previsionbudgetaire.dto.EtablissementDto;
import com.previsionbudgetaire.enumeration.TypeEtablissement;
import com.previsionbudgetaire.service.EtablissementService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etablissements")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
public class EtablissementController {

    private final EtablissementService etablissementService;

    @PostMapping("/creer")
    public ResponseEntity<EtablissementDto> create( @RequestBody EtablissementDto dto) {
        EtablissementDto created = etablissementService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EtablissementDto>> findAll() {
        List<EtablissementDto> etablissements = etablissementService.findAll();
        return ResponseEntity.ok(etablissements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtablissementDto> findById(@PathVariable Long id) {
        EtablissementDto etablissement = etablissementService.findById(id);
        return ResponseEntity.ok(etablissement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtablissementDto> update(
            @PathVariable Long id,
            @RequestBody EtablissementDto dto) {
        EtablissementDto updated = etablissementService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        etablissementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<EtablissementDto>> findByType(@PathVariable TypeEtablissement type) {
        List<EtablissementDto> etablissements = etablissementService.findByType(type);
        return ResponseEntity.ok(etablissements);
    }

    @GetMapping("/search")
    public ResponseEntity<List<EtablissementDto>> searchByIntitule(@RequestParam String intitule) {
        List<EtablissementDto> etablissements = etablissementService.searchByIntitule(intitule);
        return ResponseEntity.ok(etablissements);
    }
}