package com.cramanager.controller;

import com.cramanager.dto.affectation.AffectationRequest;
import com.cramanager.dto.affectation.AffectationResponse;
import com.cramanager.repository.AffectationRepository;
import com.cramanager.services.AffectationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/affectation")
@RequiredArgsConstructor
public class AffectationController {

    private final AffectationService affectationService;
    /*AffectationResponse getAffectationByUser(Long userId);*/

    @PostMapping
    public ResponseEntity<Void> affecter(@RequestBody AffectationRequest request){
        affectationService.affecter(request.getUserid(), request.getMissionid());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> desaffecter(@PathVariable Long userId){
        affectationService.desaffecter(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<AffectationResponse> affectationbyid (@PathVariable Long userId){
        return ResponseEntity.ok(affectationService.getAffectationByUser(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AffectationResponse>> allaffections (){
        return ResponseEntity.ok(affectationService.getAllAffectation());
    }

}
