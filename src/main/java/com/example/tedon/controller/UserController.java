package com.example.tedon.controller;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import com.example.tedon.dto.dtouser.UserLoginResquest;
import com.example.tedon.dto.dtouser.UserRequest;
import com.example.tedon.dto.dtouser.UserResponse;
import com.example.tedon.service.CustomUserDetailsService;
import com.example.tedon.service.UserService;
import com.example.tedon.utils.JwtUtil;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Inscription : on reçoit un UserRequestDto.
     * On crée un Client ou Admin selon role.
     */
    @PostMapping("/user/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRequest userRequest) {
        try {
            UserResponse created = userService.registerUser(userRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Connexion : on reçoit username et password (dans un UserRequestDto ou un DTO spécifique).
     * On authentifie via AuthenticationManager et on renvoie un token JWT.
     */
    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody UserLoginResquest loginDto) {
        try {
            // on authentifie : Spring vérifie username & password via userDetailsService + encoder
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
            );

            // si authentifié, on crée un token
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
            String token = jwtUtil.generateToken(userDetails);

            // retourner token et quelques infos utiles
            return ResponseEntity.ok().body(Map.of("token", token, "username", userDetails.getUsername()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // La déconnexion est gérée côté client en supprimant le token.
        // Le backend est stateless et ne garde pas de sessions utilisateur.
        return ResponseEntity.ok("Déconnexion réussie !");
    }

    @GetMapping("/administrateur/user/get")
    public List<UserResponse>getUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/administrateur/user/delete/{id}")
    public ResponseEntity<Void>deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Changer de mot de passe
    @SecurityRequirement(name = "bearerAuth")
    @PutMapping("/user/changePassword")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Mot de passe changé avec succès"),
        @ApiResponse(responseCode = "400", description = "Erreur lors du changement de mot de passe")
    })
    public ResponseEntity<String> changePassword(@RequestParam String username,
                                                 @RequestParam String email,
                                                 @RequestParam String newPassword) {
        try {
            String response = userService.changePassword(username, email, newPassword);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
