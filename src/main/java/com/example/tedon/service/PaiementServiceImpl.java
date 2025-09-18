package com.example.tedon.service;

import com.example.tedon.dto.paiement.PaiementResponse;
import com.example.tedon.dto.paiement.PaiementResquest;

import com.example.tedon.models.Paiement;
import com.example.tedon.repository.PaiementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PaiementServiceImpl implements PaiementService{

    @Autowired
    public PaiementRepository paiementRepository ;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PaiementResponse create(PaiementResquest paiementResquest) {
        Paiement paiement = modelMapper.map(paiementResquest,Paiement.class);
        Paiement  savedPaiement = paiementRepository.save(paiement);
        return modelMapper.map(savedPaiement, PaiementResponse.class);

    }

    @Override
    public List<PaiementResponse> getAllPaiement() {
         List< Paiement> paiements = paiementRepository.findAll();
        return   paiements.stream().map(paiement -> modelMapper.map(paiement,PaiementResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PaiementResponse> getPaiementById(Long id) {
        return paiementRepository.findById(id)
                .map(paiement -> modelMapper.map(paiement, PaiementResponse.class));
    }

    @Override
    public PaiementResponse updateById(Long id, PaiementResquest paiementResquest) {
        Paiement paiement = paiementRepository.findById(id).orElseThrow();
        modelMapper.map(paiementRepository,paiement);
        paiement = paiementRepository.save(paiement);
        return modelMapper.map(paiement, PaiementResponse.class);

    }

    @Override
    public void delete(Long id) {
        paiementRepository.deleteById(id);

    }
}
