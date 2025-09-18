package com.example.tedon.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Size(min = 3,max = 30,message = "le nom doit avoir entre 3 et 30 caractere ")

    private String nom;
    private String username;

    @Email(message = "Email droit etre valider")
    private String email;
    private String password;
    private String tel ;
    private LocalDateTime date_inscription=LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany
    @JoinTable(
            name = "user_service",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "services_id")

    )
    private List<Services> services = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "user_site_tourisique",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "site_touristique_id")

    )

    private List<Site_touristique> site_touristiques ;



    @ManyToMany
    @JoinTable(
            name = "user_reservation",
            joinColumns = @JoinColumn(name = "user_reservation"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")

    )

    private List<Reservation> reservations = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public  List< Services> getServices(){
        return this.services;
    }
    public List<Reservation> getReservations(){
        return this.reservations;
    }

    public List<Site_touristique> getSite_touristiques(){

        return this.site_touristiques;
    }

    public @Size(min = 3, max = 30, message = "le nom doit avoir entre 3 et 30 caractere ") String getNom() {
        return nom;
    }

    public void setNom(@Size(min = 3, max = 30, message = "le nom doit avoir entre 3 et 30 caractere ") String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public @Email(message = "Email droit etre valider") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email droit etre valider") String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }





    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
