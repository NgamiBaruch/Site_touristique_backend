package com.example.tedon.service;

import com.example.tedon.dto.paiement.PaiementResponse;
import com.example.tedon.dto.paiement.PaiementResquest;

import java.util.List;
import java.util.Optional;

public interface PaiementService {

    public PaiementResponse create(PaiementResquest paiementResquest);
    public List<PaiementResponse> getAllPaiement();
    public Optional<PaiementResponse> getPaiementById(Long id);
    public PaiementResponse updateById(Long id, PaiementResquest paiementResquest);
    public void delete(Long id);
}
