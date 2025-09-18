package com.example.tedon.dtoReservation;

import lombok.*;

import java.util.Date;

@Data
public class ReservationResquest {

    private String nom;
    private Date date_debut;
    private Date date_fin;
    private  Long id_client;
    private long id_service;
    private  long id_site;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public long getId_service() {
        return id_service;
    }

    public void setId_service(long id_service) {
        this.id_service = id_service;
    }

    public long getId_site() {
        return id_site;
    }

    public void setId_site(long id_site) {
        this.id_site = id_site;
    }
}
