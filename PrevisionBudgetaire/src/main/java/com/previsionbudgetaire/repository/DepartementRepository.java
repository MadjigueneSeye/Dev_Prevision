package com.previsionbudgetaire.repository;

import com.previsionbudgetaire.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartementRepository extends JpaRepository<Departement, Long> {

    List<Departement> findAllByEtablissementId(Long etablissementId);
}
