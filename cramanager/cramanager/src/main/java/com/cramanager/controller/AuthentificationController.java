package com.cramanager.controller;


import com.cramanager.dto.ConnexionRequest;
import com.cramanager.dto.InscriptionRequest;
import com.cramanager.dto.JwtAuthentificationResponse;
import com.cramanager.entity.User;
import com.cramanager.services.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthentificationController {

    private final AuthentificationService authentificationService;

    @PostMapping("/inscription")
    public ResponseEntity<User> inscription (@RequestBody InscriptionRequest inscriptionRequest) {
        return ResponseEntity.ok(authentificationService.inscription(inscriptionRequest));

    }


    @PostMapping("/connexion")

    public ResponseEntity<JwtAuthentificationResponse> signin(@RequestBody ConnexionRequest connexionRequest) {
        return ResponseEntity.ok(authentificationService.connexion(connexionRequest));
    }
}
