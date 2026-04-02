package com.cramanager.services;


import com.cramanager.dto.USER.ConnexionRequest;
import com.cramanager.dto.USER.InscriptionRequest;
import com.cramanager.dto.USER.JwtAuthentificationResponse;
import com.cramanager.dto.USER.RefreshTokenRequest;
import com.cramanager.entity.User;

public interface AuthentificationService {

    User inscription(InscriptionRequest inscriptionRequest);
    JwtAuthentificationResponse connexion(ConnexionRequest connexionRequestRequest);
    JwtAuthentificationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
