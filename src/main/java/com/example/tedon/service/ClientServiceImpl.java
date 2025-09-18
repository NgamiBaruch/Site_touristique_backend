package com.example.tedon.service;

import com.example.tedon.dto.client.ClientResponse;
import com.example.tedon.dto.client.ClientResquest;
import com.example.tedon.models.Client;
import com.example.tedon.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{


    private final  ClientRepository clientRepository;

    private final ModelMapper modelMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponse create(ClientResquest clientResquest) {

        Client client = modelMapper.map(clientResquest,Client.class);
        Client savedClient= clientRepository.save(client);
        return modelMapper.map(savedClient,ClientResponse.class);
    }

    @Override
    public List<ClientResponse> getAllClient() {
        List<Client> clients = clientRepository.findAll();
        return   clients.stream().map(client -> modelMapper
                        .map(client,ClientResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClientResponse> getClientById(Long id) {
        return clientRepository.findById(id)
                .map(client -> modelMapper.map(client,ClientResponse.class));
    }

    @Override
    public ClientResponse updateById(Long id, ClientResquest clientResquest) {
        Client client = clientRepository.findById(id).orElseThrow();
        modelMapper.map(clientResquest,client);
        client = clientRepository.save(client);
        return modelMapper.map(client,ClientResponse.class);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public Long CountClient() {
        return clientRepository.count();
    }



}
