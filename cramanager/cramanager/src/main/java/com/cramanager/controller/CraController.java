package com.cramanager.controller;

import com.cramanager.dto.CRA.CraRequest;
import com.cramanager.dto.CRA.CraResponse;
import com.cramanager.dto.CRAJour.CraJourRequest;
import com.cramanager.services.CraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cra")
@RequiredArgsConstructor
public class CraController {

    private final CraService craService;

    // Créer un CRA
    @PostMapping
    public ResponseEntity<CraResponse> creerCRA(@RequestBody CraRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(craService.creerCRA(request));
    }

    // Retrouver un CRA par id
    @GetMapping("/{craId}")
    public ResponseEntity<CraResponse> getCRAById(@PathVariable Long craId) {
        return ResponseEntity.ok(craService.getCRAById(craId));
    }

    // Retrouver tous les CRA d'un collab
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CraResponse>> getCRAByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(craService.getCRAByUser(userId));
    }

    // Remplir tous les jours ouvrés en 1 clic
    @PatchMapping("/{craId}/remplir-mois")
    public ResponseEntity<Void> remplirMois(@PathVariable Long craId) {
        craService.remplirMois(craId);
        return ResponseEntity.noContent().build();
    }

    // Remplir un jour spécifique
    @PatchMapping("/{craId}/remplir-jour")
    public ResponseEntity<Void> remplirJour(@PathVariable Long craId, @RequestBody CraJourRequest request) {
        craService.remplirJour(craId, request);
        return ResponseEntity.noContent().build();
    }

    // Soumettre le CRA
    @PatchMapping("/{craId}/soumettre")
    public ResponseEntity<Void> soumettreCRA(@PathVariable Long craId) {
        craService.soumettreCRA(craId);
        return ResponseEntity.noContent().build();
    }

    // Valider le CRA (admin)
    @PatchMapping("/{craId}/valider")
    public ResponseEntity<Void> validerCRA(@PathVariable Long craId) {
        craService.validerCRA(craId);
        return ResponseEntity.noContent().build();
    }

    // Rejeter le CRA (admin) avec motif obligatoire
    @PatchMapping("/{craId}/rejeter")
    public ResponseEntity<Void> rejeterCRA(@PathVariable Long craId, @RequestParam String motif) {
        craService.rejeterCRA(craId, motif);
        return ResponseEntity.noContent().build();
    }

    // Invalider le CRA (admin) avec motif obligatoire
    @PatchMapping("/{craId}/invalider")
    public ResponseEntity<Void> invaliderCRA(@PathVariable Long craId, @RequestParam String motif) {
        craService.invaliderCRA(craId, motif);
        return ResponseEntity.noContent().build();
    }
}