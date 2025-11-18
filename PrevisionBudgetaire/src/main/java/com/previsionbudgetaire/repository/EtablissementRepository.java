package com.previsionbudgetaire.repository;


import com.previsionbudgetaire.enumeration.TypeEtablissement;
import com.previsionbudgetaire.model.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

    List<Etablissement> findByTypeEtablissement(TypeEtablissement typeEtablissement);

    Optional<Etablissement> findBySigle(String sigle);

    boolean existsBySigle(String sigle);

    List<Etablissement> findByIntituleContainingIgnoreCase(String intitule);
}