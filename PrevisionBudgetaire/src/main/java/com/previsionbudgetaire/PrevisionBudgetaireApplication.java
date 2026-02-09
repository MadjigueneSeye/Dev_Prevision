package com.previsionbudgetaire;

import com.previsionbudgetaire.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrevisionBudgetaireApplication {

    @Autowired
    DepartementService departementService;

    public static void main(String[] args) {
        SpringApplication.run(PrevisionBudgetaireApplication.class, args);
    }

    public void initialisation(){



    }


}
