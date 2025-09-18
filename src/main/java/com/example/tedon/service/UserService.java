package com.example.tedon.service;

import com.example.tedon.dto.dtouser.UserRequest;
import com.example.tedon.dto.dtouser.UserResponse;


import java.util.List;


public interface UserService {

    public List<UserResponse> getAllUser();

    public void delete(Long id);

    //affecter tout service et les utulisateur
    public UserResponse registerUser(UserRequest userRequest) throws Exception ;

    //Changer de mot de passe

    public String changePassword(String username,String email, String newPassword);



}
