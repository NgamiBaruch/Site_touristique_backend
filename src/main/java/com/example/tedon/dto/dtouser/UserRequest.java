package com.example.tedon.dto.dtouser;


import com.example.tedon.models.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class UserRequest {

    private String nom;
    private String username;

    @Email(message = "Email droit etre valider")
    private String email;
    private Role role;
    private String password;
    private String tel ;
    private LocalDateTime date_inscription =LocalDateTime.now();

    public  String getNom() {
        return nom;
    }

    public void setNom( String nom) {
        this.nom = nom;
    }



    public  @Email(message = "Email droit etre valider") String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(@Email(message = "Email droit etre valider") String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password) {
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
