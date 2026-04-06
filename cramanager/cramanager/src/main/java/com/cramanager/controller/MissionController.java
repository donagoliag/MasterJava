package com.cramanager.controller;

import com.cramanager.dto.Mission.MissionRequest;
import com.cramanager.dto.Mission.MissionResponse;
import com.cramanager.services.MissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Missions", description = "Gestion des missions")
@RestController
@RequestMapping("/api/v1/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @Operation(summary = "Créer une mission")
    @PostMapping
    public ResponseEntity<MissionResponse> createMission(@RequestBody MissionRequest missionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(missionService.createMission(missionRequest));
    }

    @Operation(summary = "Modifier une mission")
    @PutMapping("/{id}")
    public ResponseEntity<MissionResponse> updateMission(@PathVariable Long id, @RequestBody MissionRequest missionRequest) {
        return ResponseEntity.ok(missionService.updateMission(id, missionRequest));
    }

    @Operation(summary = "Supprimer une mission")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable Long id) {
        missionService.deleteMission(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Récupérer une mission par son id")
    @GetMapping("/{id}")
    public ResponseEntity<MissionResponse> trouverMission(@PathVariable Long id) {
        return ResponseEntity.ok(missionService.getMissionById(id));
    }

    @Operation(summary = "Lister toutes les missions")
    @GetMapping
    public ResponseEntity<List<MissionResponse>> listeMission() {
        return ResponseEntity.ok(missionService.getAllMissions());
    }
}