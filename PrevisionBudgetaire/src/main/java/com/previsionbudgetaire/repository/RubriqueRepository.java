package com.previsionbudgetaire.repository;

import com.previsionbudgetaire.model.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubriqueRepository extends JpaRepository<Rubrique,Long> {


    Rubrique findByNumComptable(String numComptable);

    void deleteByNumComptable(String numComptable);
}
