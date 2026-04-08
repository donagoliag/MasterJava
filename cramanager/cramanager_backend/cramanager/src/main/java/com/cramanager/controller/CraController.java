package com.cramanager.controller;

import com.cramanager.dto.CRA.CraRequest;
import com.cramanager.dto.CRA.CraResponse;
import com.cramanager.dto.CRAJour.CraJourRequest;
import com.cramanager.services.CraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "CRA", description = "Gestion des comptes rendus d'activité")
@RestController
@RequestMapping("/api/cra")
@RequiredArgsConstructor
public class CraController {

    private final CraService craService;

    @Operation(summary = "Créer un CRA pour un collaborateur")
    @PostMapping
    public ResponseEntity<CraResponse> creerCRA(@RequestBody CraRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(craService.creerCRA(request));
    }

    @Operation(summary = "Récupérer un CRA par son id")
    @GetMapping("/{craId}")
    public ResponseEntity<CraResponse> getCRAById(@PathVariable Long craId) {
        return ResponseEntity.ok(craService.getCRAById(craId));
    }

    @Operation(summary = "Récupérer tous les CRA d'un collaborateur")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CraResponse>> getCRAByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(craService.getCRAByUser(userId));
    }

    @Operation(summary = "Remplir tous les jours ouvrés du mois")
    @PatchMapping("/{craId}/remplir-mois")
    public ResponseEntity<Void> remplirMois(@PathVariable Long craId) {
        craService.remplirMois(craId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Remplir un jour spécifique du CRA")
    @PatchMapping("/{craId}/remplir-jour")
    public ResponseEntity<Void> remplirJour(@PathVariable Long craId, @RequestBody CraJourRequest request) {
        craService.remplirJour(craId, request);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Soumettre le CRA : uniquement entre le 22 et le 28 du mois")
    @PatchMapping("/{craId}/soumettre")
    public ResponseEntity<Void> soumettreCRA(@PathVariable Long craId) {
        craService.soumettreCRA(craId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Valider un CRA : pour admin seulement")
    @PatchMapping("/{craId}/valider")
    public ResponseEntity<Void> validerCRA(@PathVariable Long craId) {
        craService.validerCRA(craId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Rejeter un CRA (pour admin seulement, motif obligatoire)")
    @PatchMapping("/{craId}/rejeter")
    public ResponseEntity<Void> rejeterCRA(@PathVariable Long craId, @RequestParam String motif) {
        craService.rejeterCRA(craId, motif);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Invalider un CRA approuvé (admin seulement, motif obligatoire)")
    @PatchMapping("/{craId}/invalider")
    public ResponseEntity<Void> invaliderCRA(@PathVariable Long craId, @RequestParam String motif) {
        craService.invaliderCRA(craId, motif);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Lister les CRA non soumis pour un mois donné (pour les alerte admin)")
    @GetMapping("/non-soumis")
    public ResponseEntity<List<CraResponse>> getCraNonSoumis(@RequestParam int mois, @RequestParam int annee) {
        return ResponseEntity.ok(craService.getCraNonSoumis(mois, annee));
    }
}