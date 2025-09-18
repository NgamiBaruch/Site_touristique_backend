package com.example.tedon.dto.dtosite_touristique;


import lombok.*;
@Data

public class Site_touristiqueResponse {

    private long id;
    private String nom ;
    private String description ;
    private String localisation;
    private String image;
    private String climat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getClimat() {
        return climat;
    }

    public void setClimat(String climat) {
        this.climat = climat;
    }
}
