package com.previsionbudgetaire.controller;

import com.previsionbudgetaire.dto.DepartementDto;
import com.previsionbudgetaire.service.DepartementService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Remove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departement")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping("/{id}")
    public DepartementDto  getDepartement(@PathVariable Long id) {
        return departementService.getDepartementById(id);
    }

    @GetMapping
    public List<DepartementDto> getDepartements()
    {
        return departementService.getDepartements();
    }

    @PostMapping
    public DepartementDto addDepartement(@RequestBody DepartementDto departementDto) {

        return departementService.saveDepartement(departementDto);

    }

    @GetMapping("/etablissement")
    public List<DepartementDto> getDepartementsByEtablissement(Long id) {
        return departementService.getDepartementsByEtablissement(id);
    }

    @PutMapping("/modifier")
    public DepartementDto  modifierDepartement(@RequestBody DepartementDto departementDto) {
        return departementService.modifierDepartement(departementDto);
    }

    @DeleteMapping("/supp/{id}")
    public void deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
    }


}
