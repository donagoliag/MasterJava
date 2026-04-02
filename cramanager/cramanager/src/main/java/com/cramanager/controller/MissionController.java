package com.cramanager.controller;

import com.cramanager.dto.Mission.MissionRequest;
import com.cramanager.dto.Mission.MissionResponse;
import com.cramanager.services.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mission")
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;

    //creation de mission
    @PostMapping()
    public ResponseEntity<MissionResponse> createMission(@RequestBody MissionRequest missionRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(missionService.createMission(missionRequest));

    }

    //update de mission
    @PutMapping("/{id}")
    public ResponseEntity<MissionResponse> updateMission(@PathVariable Long id, @RequestBody MissionRequest missionRequest){
        return ResponseEntity.ok(missionService.updateMission(id,missionRequest));
    }

    //delete mission
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable Long id){
        missionService.deleteMission(id);
        return ResponseEntity.noContent().build();
    }

    //Trouver une mission
    @GetMapping("/{id}")
    public ResponseEntity<MissionResponse> trouverMission(@PathVariable Long id){
        return ResponseEntity.ok(missionService.getMissionById(id));
    }

    //List des Missions
    @GetMapping
    public ResponseEntity<List<MissionResponse>> listeMission(){
        return ResponseEntity.ok(missionService.getAllMissions());
    }
}
