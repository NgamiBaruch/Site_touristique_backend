package com.example.tedon.dtoReservation;

import lombok.Data;

import java.sql.Date;
@Data
public class ReservationResponse {

    private long id;
    private String nom;
    private Date date_debut;
    private Date date_fin;



}
