package com.example.tedon.service;

import com.example.tedon.dto.client.ClientResponse;
import com.example.tedon.dto.client.ClientResquest;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    public ClientResponse create(ClientResquest clientResquest);
    public List<ClientResponse> getAllClient();
    public Optional<ClientResponse> getClientById(Long id);
    public ClientResponse updateById(Long id, ClientResquest clientResquest);
    public void delete(Long id);

    // COMPTER LE NOMBRE DE CLIENT

    Long CountClient();









}


