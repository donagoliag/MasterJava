package com.cramanager.services;


import com.cramanager.dto.ConnexionRequest;
import com.cramanager.dto.InscriptionRequest;
import com.cramanager.dto.JwtAuthentificationResponse;
import com.cramanager.entity.User;

public interface AuthentificationService {

    User inscription(InscriptionRequest inscriptionRequest);
    JwtAuthentificationResponse connexion(ConnexionRequest connexionRequestRequest);
}
