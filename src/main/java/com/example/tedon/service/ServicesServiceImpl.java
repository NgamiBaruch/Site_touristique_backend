package com.example.tedon.service;

import com.example.tedon.dtoservice.ServicesRequest;
import com.example.tedon.dtoservice.ServicesResponse;
import com.example.tedon.models.Services;
import com.example.tedon.models.Site_touristique;
import com.example.tedon.models.User;
import com.example.tedon.repository.ServicesRepository;
import com.example.tedon.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicesServiceImpl implements ServicesService {



    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;


    @Override
    public ServicesResponse create(ServicesRequest servicesRequest) {

        User user = userRepository.findById(servicesRequest.getId_user()).orElseThrow(()->
                new RuntimeException("service nom trouver"));

        Services services = modelMapper.map(servicesRequest,Services.class);
        services.getUsers().add(user);
        Services  savedServices = servicesRepository.save(services);
        return modelMapper.map(savedServices, ServicesResponse.class);

    }

    @Override
    public List<ServicesResponse> getAllServices() {
        List<Services> services = servicesRepository.findAll();
        return   services.stream().map(services1 -> modelMapper.map(services1,ServicesResponse.class))
                .collect(Collectors.toList());
    }



    @Override
    public Optional<ServicesResponse> getServiceById(Long id) {

        return  servicesRepository.findById(id)
                .map(services -> modelMapper.map(services, ServicesResponse.class));

    }


    @Override
    public ServicesResponse updateById(Long id, ServicesRequest servicesRequest) {
        Services services = servicesRepository.findById(id).orElseThrow();
        modelMapper.map(servicesRequest,services);
        services = servicesRepository.save(services);
        return modelMapper.map(services, ServicesResponse.class);

    }

    @Override
    public void delete(Long id) {
        servicesRepository.deleteById(id);

    }




}