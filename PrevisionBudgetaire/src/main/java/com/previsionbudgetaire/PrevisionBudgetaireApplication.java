package com.previsionbudgetaire;

import com.previsionbudgetaire.dto.DepartementDto;
import com.previsionbudgetaire.model.Departement;
import com.previsionbudgetaire.service.DepartementService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrevisionBudgetaireApplication {

    @Autowired
    DepartementService departementService;

    public static void main(String[] args) {
        SpringApplication.run(PrevisionBudgetaireApplication.class, args);
    }

    @PostConstruct
    public void initialisation() {
        for (int i=0;i<5;i++)
        {

            DepartementDto departement = new DepartementDto();
            departement.setLibelle("Departement"+i);
            departementService.saveDepartement(departement);
        }
    }



}
