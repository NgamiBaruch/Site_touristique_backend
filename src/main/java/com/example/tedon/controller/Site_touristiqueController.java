package com.example.tedon.controller;


import com.example.tedon.dto.dtosite_touristique.Site_touristiqueResponse;
import com.example.tedon.dto.dtosite_touristique.Site_touristiqueResquest;
import com.example.tedon.models.Site_touristique;
import com.example.tedon.service.Site_touristiqueService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class Site_touristiqueController {

    @Autowired
    private Site_touristiqueService site_touristiqueService;


    @PostMapping("/administrateur/site_touristique/create")
    public Site_touristiqueResponse create(@RequestBody Site_touristiqueResquest site_touristiqueResquest){
        return  site_touristiqueService.create(site_touristiqueResquest);
    }

    @GetMapping("/administrateur/site_touristique/get")
    public List<Site_touristiqueResponse> getSite_touristique(){
        return site_touristiqueService.getAllSite_touristique();

    }
    @GetMapping("/administrateur/site_touristique/{id}")
    public ResponseEntity<Site_touristiqueResponse> getSite_touristiqueById(@PathVariable Long id){
    return site_touristiqueService.getSite_touristiqueById(id).map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PutMapping("/administrateur/site_touristique/{id}")

    public Site_touristiqueResponse update(@PathVariable Long id,@RequestBody Site_touristiqueResquest site_touristiqueResquest){
        return site_touristiqueService.updateById(id,site_touristiqueResquest);
    }

    @DeleteMapping("/administrateur/site_touristique/{id}")

    public ResponseEntity<Void>deleteAgent(@PathVariable Long id){
        site_touristiqueService.delete(id);
        return ResponseEntity.noContent().build();
    }
    //recherche par nom
    @GetMapping("/administrateur/site_touristique/rechercher/{nom}")
    public ResponseEntity<Site_touristique> rechercheParnom( @PathVariable String nom){

        return new ResponseEntity<>(site_touristiqueService.rechercheParnom(nom), HttpStatus.OK);
    }



}
