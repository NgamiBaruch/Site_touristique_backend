package com.example.tedon.controller;

import com.example.tedon.dto.administrateur.AdministrateurResponse;
import com.example.tedon.dto.administrateur.AdministrateurResquest;
import com.example.tedon.service.AdministrateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrateur")
@AllArgsConstructor
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;

    @PostMapping ("/create")
    public AdministrateurResponse create(@RequestBody AdministrateurResquest administrateurResquest){
        return  administrateurService.create(administrateurResquest);
    }

    @GetMapping("/get")
    public List<AdministrateurResponse>getAdministrateur(){
        return administrateurService.getAllAdministrateur();

    }
    @GetMapping("/{id}")
    public ResponseEntity<AdministrateurResponse>getAdministrateurById(@PathVariable Long id){
        return administrateurService.getAdministrateurById(id).map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")

    public AdministrateurResponse update(@PathVariable Long id,@RequestBody AdministrateurResquest administrateurResquest){
        return administrateurService.updateById(id,administrateurResquest);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void>deleteAdministrateur(@PathVariable Long id){
        administrateurService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
