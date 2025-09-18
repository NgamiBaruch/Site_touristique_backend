package com.example.tedon.dto.client;

import com.example.tedon.dto.dtouser.UserResponse;
import lombok.Data;

@Data
public class ClientResponse extends UserResponse {

    private String preference;

}
