package com.example.tedon.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Site_touristique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id ;
    @NotNull
    @Size(min = 3,max = 30,message = "le nom doit avoir entre 3 et 30 caractere ")

    private String nom;
    private String  description ;
    private String localisation;
    private String image;
    private String climat;

    @ManyToMany(mappedBy = "site_touristiques")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
