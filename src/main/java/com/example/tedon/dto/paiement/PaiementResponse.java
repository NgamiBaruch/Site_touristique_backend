package com.example.tedon.dto.paiement;

import lombok.Data;

import java.util.Date;
@Data

public class PaiementResponse {

    private long id;
    private int montant;
    private Date date_paiement;
    private String methode_paiement;


}
