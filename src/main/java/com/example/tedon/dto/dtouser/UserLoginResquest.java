package com.example.tedon.dto.dtouser;

import com.example.tedon.models.Role;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserLoginResquest {

    private String username;

    @Email(message = "Email droit etre valider")
    private String email;

    private String password;

    public UserLoginResquest(String email, String password) {
        this.email = email;
        this.password = password;
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
}
