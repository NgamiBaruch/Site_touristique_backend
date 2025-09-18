package com.example.tedon.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @NotNull
    @Size(min = 3,max = 30,message = "le nom doit avoir entre 3 et 30 caractere ")

    private String nom ;
    private LocalDate  date ;
    //private LocalDate date_fin ;

    @ManyToMany(mappedBy = "reservations")
    private List<User> users;


    @OneToMany(mappedBy = "reservations",fetch = FetchType.LAZY)
   private List<Paiement> paiements ;

    public List<User>getUsers(){
        return this.users;
    }
    public List<Services> getServices(){
        return this.getServices();

    }
    public List<Site_touristique> getSite_touristique(){
        return this.getSite_touristique();
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
