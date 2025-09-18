package com.example.tedon.service;


import com.example.tedon.dto.dtosite_touristique.Site_touristiqueResponse;


import com.example.tedon.dto.dtosite_touristique.Site_touristiqueResquest;
import com.example.tedon.models.Site_touristique;

import java.util.List;
import java.util.Optional;


public interface Site_touristiqueService {

    public Site_touristiqueResponse create(Site_touristiqueResquest siteTouristiqueRequest);
    public List<Site_touristiqueResponse> getAllSite_touristique();
    public Optional<Site_touristiqueResponse> getSite_touristiqueById(Long id);
    public Site_touristiqueResponse updateById(Long id, Site_touristiqueResquest site_touristiqueResquest);
    public void delete(Long id);

    //recherche des site
    public   Site_touristique rechercheParnom(String nom);


}
