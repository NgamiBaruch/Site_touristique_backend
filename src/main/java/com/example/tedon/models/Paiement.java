package com.example.tedon.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private float montant_paiement ;
    private Date date_paiement;
    private String methode_paiement;
    private String statut ;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private  Reservation reservations;


}
