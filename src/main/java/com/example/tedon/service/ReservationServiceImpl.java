package com.example.tedon.service;


import com.example.tedon.dtoReservation.ReservationResponse;
import com.example.tedon.dtoReservation.ReservationResquest;
import com.example.tedon.models.Client;
import com.example.tedon.models.Reservation;
import com.example.tedon.models.Site_touristique;
import com.example.tedon.repository.ClientRepository;
import com.example.tedon.repository.ReservationRepository;
import com.example.tedon.repository.ServicesRepository;
import com.example.tedon.repository.Site_touristiqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private Site_touristiqueRepository site_touristiqueRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public ReservationResponse create(ReservationResquest reservationResquest) {

        Reservation reservation1 = modelMapper.map(reservationResquest,Reservation.class);
        Reservation savedReservation= reservationRepository.save(reservation1);

        return modelMapper.map(savedReservation,ReservationResponse.class);

//        Reservation reservation1 = modelMapper.map(reservation, Reservation.class);
//        Client client = clientRepository.findById(reservation.getId_client())
//                .orElseThrow(()->new RuntimeException("client nom trouver"));
//
//        com.example.tedon.models.Services service = servicesRepository.findById(reservation.getId_service())
//                .orElseThrow(()->new RuntimeException("service nom trouver"));
//        Site_touristique site_touristique = site_touristiqueRepository.findById(reservation.getId_site())
//                .orElseThrow(()->new RuntimeException("site_touristique nom trouver"));
//                        reservation1.getUsers().add(client);
//                        reservation1.getServices().add(service);
//                        reservation1.getSite_touristique().add(site_touristique);
//                        Reservation nouvelleReservation = reservationRepository.save(reservation1);
//                        return modelMapper.map(nouvelleReservation,ReservationResponse.class);
   }


    @Override
    public List<ReservationResponse> getAllReservation() {

        List<Reservation> reservations = reservationRepository.findAll();
        return   reservations.stream().map(reservation -> modelMapper.map(reservation, ReservationResponse.class))
                .collect(Collectors.toList());


    }

    @Override
    public Optional<ReservationResponse> getReservationById(Long id) {
        return  reservationRepository.findById(id)
                .map(reservation -> modelMapper.map(reservation, ReservationResponse.class));

    }

    @Override
    public ReservationResponse updateById(Long id, ReservationResquest reservation) {
        Reservation reservation1 = reservationRepository.findById(id).orElseThrow();
        modelMapper.map(reservation,reservation1);
        reservation1 = reservationRepository.save(reservation1);
        return modelMapper.map(reservation,ReservationResponse.class);


    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);

    }



}



