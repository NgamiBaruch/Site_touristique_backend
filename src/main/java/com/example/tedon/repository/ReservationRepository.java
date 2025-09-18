package com.example.tedon.repository;

import com.example.tedon.models.Reservation;
import com.example.tedon.models.Site_touristique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

//    //valorisation de reservation journalier et mensuel
//    @Query("SELECT r.date, COUNT(r) FROM reservation r GROUP BY r .date")
//    List<Object[]> getDailyReservation();
//    @Query("SELECT FUNTION ('MONTH',r.date),COUNT(r) FROM Reservation r GROUP BY FUNCTION('MONTH',r.date)")
//
//    List<Object[]> getMonthlyReservation();
}
