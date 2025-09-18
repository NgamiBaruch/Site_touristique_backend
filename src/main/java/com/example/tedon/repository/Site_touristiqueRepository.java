package com.example.tedon.repository;

import com.example.tedon.models.Site_touristique;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Site_touristiqueRepository extends JpaRepository<Site_touristique, Long> {

    // rechercher le site par son nom

    Site_touristique findBynom(String nom);
}
