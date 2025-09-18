package com.example.tedon.service;

import com.example.tedon.dto.dtouser.UserRequest;
import com.example.tedon.dto.dtouser.UserResponse;
import com.example.tedon.models.*;
import com.example.tedon.repository.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private Site_touristiqueRepository site_touristiqueRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdministrateurRepository administrateurRepository;
    @Autowired
    private AgentRepository agentRepository;

    @Override
    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        return   users.stream().map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }
    //incription

    @Override
    public UserResponse registerUser(UserRequest userRequest) throws Exception {
        // verification  : username/email unique
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new Exception("Username already taken");
        }
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new Exception("Email already used");
        }

        // chiffrage du mot de passe
        //String encodedPwd = passwordEncoder.encode(dto.getPassword());
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        // création selon role
        if (userRequest.getRole() == Role.ROLE_CLIENT) {
            //Client client = new Client(dto.getName(), dto.getUsername(), dto.getEmail(), encodedPwd, dto.getTelephone(), Role.ROLE_CLIENT, /preference/ null);
            Client client = modelMapper.map(userRequest, Client.class);
            Client saved = clientRepository.save(client);
            return modelMapper.map(saved, UserResponse.class);
        } else if (userRequest.getRole() == Role.ROLE_ADMINISTRATEUR) {
            //Admin admin = new Admin(dto.getName(), dto.getUsername(), dto.getEmail(), encodedPwd, dto.getTelephone(), Role.Role_Admin, /code/ null);
            Administrateur administrateur = modelMapper.map(userRequest,Administrateur.class);
            Administrateur saved = administrateurRepository.save(administrateur);
            return modelMapper.map(saved, UserResponse.class);
        } else if (userRequest.getRole() == Role.ROLE_AGENT) {
            //Admin admin = new Admin(dto.getName(), dto.getUsername(), dto.getEmail(), encodedPwd, dto.getTelephone(), Role.Role_Admin, /code/ null);
            Agent agent = modelMapper.map(userRequest, Agent.class);
            Agent saved = agentRepository.save(agent);
            return modelMapper.map(saved, UserResponse.class);
        }          // Assurez-vous que le rôle est assigné, si ce n'est pas déjà le cas
        else {
            throw new Exception("Role non supporté");
        }
    }

    @Override
    public String changePassword(String username, String email, String newPassword) {
        Optional<User> user = userRepository.findUserByUsername(username);

        if (user.isEmpty()) {
            return "User not found with username: " + username;
        }

        if (!user.get().getEmail().equals(email)) {
            return "Email does not match for username: " + username;
        }

        // Chiffrer le nouveau mot de passe
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        User actualUser = user.get();
        actualUser.setPassword(encodedNewPassword);
        userRepository.save(actualUser);

        return "Password changed successfully for user: " + username;
    }






}
