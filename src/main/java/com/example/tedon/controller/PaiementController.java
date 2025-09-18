package com.example.tedon.controller;

import com.example.tedon.dto.administrateur.AdministrateurResponse;
import com.example.tedon.dto.administrateur.AdministrateurResquest;
import com.example.tedon.dto.paiement.PaiementResponse;
import com.example.tedon.dto.paiement.PaiementResquest;
import com.example.tedon.service.PaiementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/paiement")
@AllArgsConstructor
public class PaiementController {

    @Autowired
    private PaiementService paiementService;


    @GetMapping("/get")
    public List<PaiementResponse> getPaiement(){
        return paiementService.getAllPaiement();

    }
    @GetMapping("/{id}")
    public ResponseEntity<PaiementResponse> getPaiementById(@PathVariable Long id){
        return paiementService.getPaiementById(id).map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")

    public PaiementResponse update(@PathVariable Long id,@RequestBody PaiementResquest paiementResquest){
        return paiementService.updateById(id,paiementResquest);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void>deleteAdministrateur(@PathVariable Long id){
        paiementService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
