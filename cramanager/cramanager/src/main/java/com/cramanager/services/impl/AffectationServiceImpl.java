package com.cramanager.services.impl;

import com.cramanager.dto.affectation.AffectationResponse;
import com.cramanager.entity.Affectation;
import com.cramanager.entity.Mission;
import com.cramanager.entity.User;
import com.cramanager.repository.AffectationRepository;
import com.cramanager.repository.MissionRepository;
import com.cramanager.repository.UserRepository;
import com.cramanager.services.AffectationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AffectationServiceImpl implements AffectationService {

    private final AffectationRepository affectationRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;

    //affecter un collab à une mission
    public void affecter(Long userId, Long missionId){

        //Retrouver la mission
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(()->new EntityNotFoundException("Mission non trouve avec l'id : "+ missionId));
        //Retrouver le user
        User user = userRepository.findById(userId)
                .orElseThrow(()->new EntityNotFoundException("User non trouve avec l'id : "+ userId));

        //Pour la mission et ce user creer une affectation
        Affectation affectation = new Affectation();
        affectation.setUser(user);
        affectation.setMission(mission);
        affectation.setDateAffectation(LocalDate.now());

        affectationRepository.save(affectation);

    }

    //retirer le collab de sa mission.
    public void desaffecter(Long userId){
        //retrouver l'affectation ou y le userId

        Affectation affectation = affectationRepository.findByUserId(userId)
                .orElseThrow(()->new EntityNotFoundException("Affectation non trouve pour lutilisateur avec l'id : "+ userId));

        affectationRepository.delete(affectation);
    }

    //retourner l'affectation active d'un collab
    public AffectationResponse getAffectationByUser(Long userId){

        Affectation affectation = affectationRepository.findByUserId(userId)
                .orElseThrow(()->new EntityNotFoundException("Affectation non trouve pour lutilisateur avec l'id : "+ userId));


        AffectationResponse affectationResponse = new AffectationResponse();

        affectationResponse.setId(affectation.getId());
        affectationResponse.setMissionid(affectation.getMission().getId());
        affectationResponse.setUserid(affectation.getUser().getId());
        affectationResponse.setDateAffectation(affectation.getDateAffectation());

        return affectationResponse;
    }

}
