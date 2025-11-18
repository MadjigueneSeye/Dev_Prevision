package com.previsionbudgetaire.repository;

import com.previsionbudgetaire.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

    // Trouver toutes les formations d'un département
    List<Formation> findByDepartementId(Long departementId);

    // Trouver une formation par libellé
    Optional<Formation> findByLibelleIgnoreCase(String libelle);

    // Vérifier si une formation existe déjà pour un département
    boolean existsByLibelleIgnoreCaseAndDepartementId(String libelle, Long departementId);

    // Recherche par libellé contenant (pour l'autocomplétion)
    @Query("SELECT f FROM Formation f WHERE LOWER(f.libelle) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Formation> searchByLibelle(@Param("keyword") String keyword);

    // Récupérer les formations avec leur département (optimisation)
    @Query("SELECT f FROM Formation f LEFT JOIN FETCH f.departement WHERE f.id = :id")
    Optional<Formation> findByIdWithDepartement(@Param("id") Long id);

    // Récupérer toutes les formations avec leur département
    @Query("SELECT f FROM Formation f LEFT JOIN FETCH f.departement")
    List<Formation> findAllWithDepartement();
}
