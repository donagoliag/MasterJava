package com.cramanager.controller;

import com.cramanager.dto.affectation.AffectationRequest;
import com.cramanager.dto.affectation.AffectationResponse;
import com.cramanager.services.AffectationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Affectations", description = "Gestion des affectations collaborateur ↔ mission")
@RestController
@RequestMapping("/api/v1/affectation")
@RequiredArgsConstructor
public class AffectationController {

    private final AffectationService affectationService;

    @Operation(summary = "Affecter un collaborateur à une mission")
    @PostMapping
    public ResponseEntity<Void> affecter(@RequestBody AffectationRequest request) {
        affectationService.affecter(request.getUserid(), request.getMissionid());
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Retirer un collaborateur de sa mission")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> desaffecter(@PathVariable Long userId) {
        affectationService.desaffecter(userId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Récupérer l'affectation active d'un collaborateur")
    @GetMapping("/{userId}")
    public ResponseEntity<AffectationResponse> affectationbyid(@PathVariable Long userId) {
        return ResponseEntity.ok(affectationService.getAffectationByUser(userId));
    }

    @Operation(summary = "Lister toutes les affectations")
    @GetMapping("/all")
    public ResponseEntity<List<AffectationResponse>> allaffections() {
        return ResponseEntity.ok(affectationService.getAllAffectation());
    }
}