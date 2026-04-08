package com.cramanager.services;


import com.cramanager.dto.User.ConnexionRequest;
import com.cramanager.dto.User.InscriptionRequest;
import com.cramanager.dto.User.JwtAuthentificationResponse;
import com.cramanager.dto.User.RefreshTokenRequest;
import com.cramanager.entity.User;

public interface AuthentificationService {

    User inscription(InscriptionRequest inscriptionRequest);
    JwtAuthentificationResponse connexion(ConnexionRequest connexionRequestRequest);
    JwtAuthentificationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
