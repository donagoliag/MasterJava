package com.cramanager.services.impl;

import com.cramanager.dto.ConnexionRequest;
import com.cramanager.dto.InscriptionRequest;
import com.cramanager.dto.JwtAuthentificationResponse;
import com.cramanager.entity.User;
import com.cramanager.enumeration.UserRoles;
import com.cramanager.repository.UserRepository;
import com.cramanager.services.AuthentificationService;
import com.cramanager.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthentificationServiceImpl implements AuthentificationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public User inscription(InscriptionRequest inscriptionRequest){
        User user = new User();
        user.setEmail(inscriptionRequest.getEmail());
        user.setNom(inscriptionRequest.getNom());
        user.setPrenom(inscriptionRequest.getPrenom());
        user.setRole(UserRoles.USER);
        user.setContrat(inscriptionRequest.getContrat());
        user.setSeniorite(inscriptionRequest.getSeniorite());
        user.setStatut(inscriptionRequest.getStatut());
        user.setSalaire(inscriptionRequest.getSalaire());
        user.setPassword(passwordEncoder.encode(inscriptionRequest.getPassword()));

        return userRepository.save(user);

    }

    public JwtAuthentificationResponse connexion(ConnexionRequest connexionRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(connexionRequest.getEmail(),connexionRequest.getPassword()));

        var user = userRepository.findByEmail(connexionRequest.getEmail())
                .orElseThrow(()->new IllegalArgumentException(("Invalid email or password")));

        var jwt = jwtService.generationToken(user);
        var refreshtoken=jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthentificationResponse jwtAuthentificationResponse = new JwtAuthentificationResponse();
        jwtAuthentificationResponse.setToken(jwt);
        jwtAuthentificationResponse.setRefreshToken(jwt);
        return jwtAuthentificationResponse;
    }

}
