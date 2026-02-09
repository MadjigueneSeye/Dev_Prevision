package com.previsionbudgetaire.controller;

import com.previsionbudgetaire.dto.DepartementDto;
import com.previsionbudgetaire.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class
DepartementController {

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

    @DeleteMapping("/supp/{id}")
    public void deleteDepartement(@RequestBody Long id) {
        departementService.deleteDepartement(id);
    }


}
