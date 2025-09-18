package com.example.tedon.service;


import com.example.tedon.dto.dtosite_touristique.Site_touristiqueResponse;
import com.example.tedon.dto.dtosite_touristique.Site_touristiqueResquest;

import com.example.tedon.models.Site_touristique;
import com.example.tedon.models.User;
import com.example.tedon.repository.Site_touristiqueRepository;
import com.example.tedon.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Site_touristiqueServiceImpl implements Site_touristiqueService {


    @Autowired
    private Site_touristiqueRepository site_touristiqueRepository;
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Site_touristiqueResponse create(Site_touristiqueResquest siteTouristiqueRequest) {

        User user = userRepository.findById(siteTouristiqueRequest.getId_user()).orElseThrow(()
        -> new RuntimeException("site nom trouver"));
        Site_touristique site_touristique = modelMapper.map(siteTouristiqueRequest,Site_touristique.class);
        site_touristique.getUsers().add(user);
        Site_touristique  savedSite_touristique = site_touristiqueRepository.save(site_touristique);
        return modelMapper.map(savedSite_touristique, Site_touristiqueResponse.class);
    }

    @Override
    public List<Site_touristiqueResponse> getAllSite_touristique() {
        List<Site_touristique> site_touristiques = site_touristiqueRepository.findAll();
        return   site_touristiques.stream().map(site_touristique -> modelMapper.map(site_touristique, Site_touristiqueResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Site_touristiqueResponse> getSite_touristiqueById(Long id) {
        return  site_touristiqueRepository.findById(id)
                .map(site_touristique -> modelMapper.map(site_touristique, Site_touristiqueResponse.class));

    }

    @Override
    public Site_touristiqueResponse updateById(Long id, Site_touristiqueResquest Site_touristique) {

        Site_touristique site_touristique = site_touristiqueRepository.findById(id).orElseThrow();
        modelMapper.map(site_touristique,site_touristique);
        site_touristique = site_touristiqueRepository.save(site_touristique);
        return modelMapper.map(site_touristique,Site_touristiqueResponse.class);


    }

    @Override
    public void delete(Long id) {
        site_touristiqueRepository.deleteById(id);

    }

    @Override
    public Site_touristique rechercheParnom(String nom) {
        Site_touristique site_touristique = site_touristiqueRepository.findBynom("nom");
        return site_touristique;
    }
    



}
