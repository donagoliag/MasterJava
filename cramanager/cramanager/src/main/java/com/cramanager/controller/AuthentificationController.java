package com.cramanager.controller;


import com.cramanager.dto.InscriptionRequest;
import com.cramanager.entity.User;
import com.cramanager.services.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AuthentificationController {

    private final AuthentificationService authentificationService;

    @PostMapping("/Inscription")
    public ResponseEntity<User> inscription (@RequestBody InscriptionRequest inscriptionRequest) {
        return ResponseEntity.ok(authentificationService.inscription(inscriptionRequest));

    }
}
