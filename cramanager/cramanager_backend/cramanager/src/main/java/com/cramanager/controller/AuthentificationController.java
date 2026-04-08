package com.cramanager.controller;


import com.cramanager.dto.User.ConnexionRequest;
import com.cramanager.dto.User.InscriptionRequest;
import com.cramanager.dto.User.JwtAuthentificationResponse;
import com.cramanager.dto.User.RefreshTokenRequest;
import com.cramanager.entity.User;
import com.cramanager.services.AuthentificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Authentification", description = "Inscription, connexion et refresh token")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthentificationController {

    private final AuthentificationService authentificationService;

    @Operation(summary = "Créer un compte collaborateur")
    @PostMapping("/inscription")
    public ResponseEntity<User> inscription(@RequestBody InscriptionRequest inscriptionRequest) {
        return ResponseEntity.ok(authentificationService.inscription(inscriptionRequest));
    }

    @Operation(summary = "Se connecter et obtenir un token JWT")
    @PostMapping("/connexion")
    public ResponseEntity<JwtAuthentificationResponse> signin(@RequestBody ConnexionRequest connexionRequest) {
        return ResponseEntity.ok(authentificationService.connexion(connexionRequest));
    }

    @Operation(summary = "Rafraîchir le token JWT")
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthentificationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authentificationService.refreshToken(refreshTokenRequest));
    }
}