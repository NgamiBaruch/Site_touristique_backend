package com.example.tedon.service;

import com.example.tedon.dto.administrateur.AdministrateurResponse;
import com.example.tedon.dto.administrateur.AdministrateurResquest;
import com.example.tedon.dto.client.ClientResponse;
import org.modelmapper.internal.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AdministrateurService {

    public AdministrateurResponse create(AdministrateurResquest administrateurResquest);
    public List<AdministrateurResponse> getAllAdministrateur();
    public Optional<AdministrateurResponse> getAdministrateurById(Long id);
    public AdministrateurResponse updateById(Long id, AdministrateurResquest administrateurResquest);
    public void delete(Long id);

    // le login ou connexion

}
