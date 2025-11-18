package com.previsionbudgetaire.enumeration;

public enum TypeEtablissement {
    FACULTE("Faculté"),
    ECOLE("École"),
    INSTITUT("Institut");

    private final String libelle;

    TypeEtablissement(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}