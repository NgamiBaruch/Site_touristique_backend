package com.example.tedon.service;


import com.example.tedon.dtoReservation.ReservationResponse;
import com.example.tedon.dtoservice.ServicesRequest;
import com.example.tedon.dtoservice.ServicesResponse;

import java.util.List;
import java.util.Optional;

public interface ServicesService {

    public ServicesResponse create(ServicesRequest servicesRequest);
    public List<ServicesResponse> getAllServices();
    public Optional<ServicesResponse> getServiceById(Long id);
    public ServicesResponse updateById(Long id, ServicesRequest servicesRequest);
    public void delete(Long id);
    //la recherche
}
