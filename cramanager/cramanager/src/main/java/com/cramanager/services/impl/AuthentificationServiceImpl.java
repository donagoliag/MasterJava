package com.cramanager.services.impl;

import com.cramanager.dto.InscriptionRequest;
import com.cramanager.entity.User;
import com.cramanager.enumeration.UserRoles;
import com.cramanager.repository.UserRepository;
import com.cramanager.services.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentificationServiceImpl implements AuthentificationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User inscription(InscriptionRequest inscriptionRequest){
        User user = new User();
        user.setEmail(inscriptionRequest.getEmail());
        user.setNom(inscriptionRequest.getNom());
        user.setPrenom(inscriptionRequest.getPrenom());
        user.setRole(UserRoles.USER);
        user.setPassword(passwordEncoder.encode(inscriptionRequest.getPassword()));

        return userRepository.save(user);

    }


}
