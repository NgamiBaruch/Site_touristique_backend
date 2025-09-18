package com.example.tedon.service;

import com.example.tedon.dto.administrateur.AdministrateurResponse;
import com.example.tedon.dto.administrateur.AdministrateurResquest;

import com.example.tedon.models.Administrateur;

import com.example.tedon.repository.AdministrateurRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service

public class AdministrateurServiceImpl implements AdministrateurService {


    @Autowired
    private AdministrateurRepository administrateurRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdministrateurResponse create(AdministrateurResquest administrateurResquest) {
        Administrateur administrateur = modelMapper.map(administrateurResquest,Administrateur.class);
        Administrateur savedAdministrateur= administrateurRepository.save(administrateur);

        return modelMapper.map(savedAdministrateur, AdministrateurResponse.class);
    }

    @Override
    public List<AdministrateurResponse> getAllAdministrateur() {
        List<Administrateur> administrateurs = administrateurRepository.findAll();

        return   administrateurs.stream().map(administrateur ->  modelMapper.map(administrateur,AdministrateurResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AdministrateurResponse> getAdministrateurById(Long id) {

        return  administrateurRepository.findById(id)
                .map(administrateur -> modelMapper.map(administrateur,AdministrateurResponse.class));
    }

    @Override
    public AdministrateurResponse updateById(Long id, AdministrateurResquest administrateurResquest) {
        Administrateur administrateur = administrateurRepository.findById(id).orElseThrow();
        modelMapper.map(administrateurResquest,administrateur);
        administrateur = administrateurRepository.save(administrateur);
        return modelMapper.map(administrateur,AdministrateurResponse.class);

    }

    @Override
    public void delete(Long id) {
        administrateurRepository.deleteById(id);

    }


}
