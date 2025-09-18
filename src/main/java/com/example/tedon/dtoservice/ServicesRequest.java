package com.example.tedon.dtoservice;

import lombok.Data;

@Data
public class ServicesRequest {

    private Long id_user;
    private String nom;
    private float prix;
    private String emplacement ;
    private String type_service;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
}
