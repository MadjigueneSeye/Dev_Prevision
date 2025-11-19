package com.previsionbudgetaire.repository;

import com.previsionbudgetaire.model.Prevision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrevisionRepository extends JpaRepository<Prevision,Long> {
    List<Prevision> findAllByEtablissementId(long id);
}
