package com.example.tedon.service;


import com.example.tedon.dto.hebergement.HebergementResquest;
import com.example.tedon.dto.hebergement.HebergementResponse;

import java.util.List;
import java.util.Optional;

public interface HebergementService {

    public HebergementResponse create(HebergementResquest hebergementResquest);
    public List<HebergementResponse> getAllHebergement();
    public Optional<HebergementResponse> getHerbergementById(Long id);
    public HebergementResponse updateById(Long id, HebergementResquest hebergementResquest);
    public void delete(Long id);
}
