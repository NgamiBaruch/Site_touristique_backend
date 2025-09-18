package com.example.tedon.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("hebergement")

public class Hebergement extends Services {

    private String type_hebergement ;
    private  int nombre_chambre ;

}
