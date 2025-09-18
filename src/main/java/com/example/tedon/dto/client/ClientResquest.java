package com.example.tedon.dto.client;

import com.example.tedon.dto.dtouser.UserRequest;
import lombok.Data;

@Data
public class ClientResquest extends UserRequest {

    private String preference;

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
