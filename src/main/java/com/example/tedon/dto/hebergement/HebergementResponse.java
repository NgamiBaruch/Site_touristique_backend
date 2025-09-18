package com.example.tedon.dto.hebergement;

import com.example.tedon.models.Services;
import lombok.Data;

@Data
public class HebergementResponse extends Services {

    private String type_hebergement ;
    private  int nombre_chambre ;

}
