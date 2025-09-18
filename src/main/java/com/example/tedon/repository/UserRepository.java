package com.example.tedon.repository;

import com.example.tedon.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long > {

    Optional<User> findUserByUsername(String username);

    boolean existsByUsername(String Username);

    boolean existsByEmail(String email);


    
}