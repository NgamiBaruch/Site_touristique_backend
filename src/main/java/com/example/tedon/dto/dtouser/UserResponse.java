package com.example.tedon.dto.dtouser;

import com.example.tedon.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserResponse {
    private long id;
    private String nom;
    private String username;
    private String tel;
    private  Role role;
    private LocalDateTime date_inscription =LocalDateTime.now();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
