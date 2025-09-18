package com.example.tedon.service;


import com.example.tedon.dtoReservation.ReservationResponse;
import com.example.tedon.dtoReservation.ReservationResquest;
import com.example.tedon.models.Reservation;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ReservationService {

    public ReservationResponse create(ReservationResquest reservationResquest);
    public List<ReservationResponse> getAllReservation();
    public Optional<ReservationResponse> getReservationById(Long id);
    public ReservationResponse updateById(Long id, ReservationResquest reservation);
    public void delete(Long id);
//
//    // le login ou connexion
//   // public Map<LocalDate, Date> getDailyReservation();
//   // public Map<YearMonth,Date> getMonthlyReservation();
//    //jounalier et mensuel
//      public List<Object[]> getDailyReservation();
//    public List<Object[]> getMonthlyReservation();


}
