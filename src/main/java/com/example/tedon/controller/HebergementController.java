package com.example.tedon.controller;

import com.example.tedon.dto.hebergement.HebergementResquest;

import com.example.tedon.dto.hebergement.HebergementResponse;
import com.example.tedon.service.HebergementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hebergement")
@AllArgsConstructor
public class HebergementController {

    @Autowired
    private HebergementService hebergementService;

    @PostMapping("/create")
    public HebergementResponse create(@RequestBody HebergementResquest hebergementResquest){
        return  hebergementService.create(hebergementResquest);
    }

    @GetMapping("/get")
    public List<HebergementResponse> getHebergement(){
        return hebergementService.getAllHebergement();

    }
    @GetMapping("/{id}")
    public ResponseEntity<HebergementResponse> getHebergementById(@PathVariable Long id){
        return hebergementService.getHerbergementById(id).map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")

    public HebergementResponse update(@PathVariable Long id, @RequestBody HebergementResquest hebergementResquest){
        return hebergementService.updateById(id,hebergementResquest);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void>deleteHebergement(@PathVariable Long id){
        hebergementService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
