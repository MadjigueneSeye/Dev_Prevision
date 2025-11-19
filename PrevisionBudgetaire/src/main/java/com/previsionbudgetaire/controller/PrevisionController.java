package com.previsionbudgetaire.controller;

import com.previsionbudgetaire.dto.PrevisionDto;
import com.previsionbudgetaire.service.PrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prevision")
public class PrevisionController {

    @Autowired
    private PrevisionService previsionService;

    @GetMapping("/{id}")
    public PrevisionDto getPrevision(@PathVariable Long id){
        return previsionService.findById(id);
    }

    @GetMapping
    public List<PrevisionDto> getPrevisions(){
        return previsionService.findAll();
    }

    @PostMapping
    public PrevisionDto addPrevision(@RequestBody PrevisionDto previsionDto){
        return previsionService.save(previsionDto);
    }

    @PutMapping("/modifier")
    public PrevisionDto updatePrevision(@RequestBody PrevisionDto previsionDto){
        return previsionService.save(previsionDto);
    }

    @DeleteMapping("/supprimer")
    public void deletePrevision(Long id){
        previsionService.deleteById(id);
    }


    @GetMapping("/etablissement")
    public List<PrevisionDto> getPrevisionByetablissement(Long id){
        return previsionService.findAllByEtablissementId(id);
    }
}
