package com.previsionbudgetaire.controller;

import com.previsionbudgetaire.dto.RubriqueDto;
import com.previsionbudgetaire.service.RubriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rubrique")
public class RubriqueController {
    @Autowired
    RubriqueService rubriqueService;

    @PostMapping
    public RubriqueDto save(@RequestBody RubriqueDto rubriqueDto) {
        RubriqueDto rubriqueDto1 = rubriqueService.save(rubriqueDto);
        System.out.println("=================="+rubriqueDto1.getNumComptable());

        return rubriqueDto1;

    }

    @GetMapping("/{id}")
    public RubriqueDto getById(@PathVariable String id) {
        return rubriqueService.findById(id);
    }


    @GetMapping
    public List<RubriqueDto> getAllRubrique() {
        return rubriqueService.findAll();
    }

    @DeleteMapping("/supprimer/{id}")
    public void delete(@PathVariable String id) {
        rubriqueService.deleteById(id);
    }

    @PutMapping("/modifier")
    public RubriqueDto updateRubrique(@RequestBody RubriqueDto rubriqueDto) {
        return rubriqueService.updateById(rubriqueDto);
    }
}
