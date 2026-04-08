package com.cramanager.services.impl;

import com.cramanager.dto.Mission.MissionRequest;
import com.cramanager.dto.Mission.MissionResponse;
import com.cramanager.entity.Mission;
import com.cramanager.repository.MissionRepository;
import com.cramanager.services.MissionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;


    //Creer une mission
    public MissionResponse createMission(MissionRequest request){
        Mission mission = new Mission();

        mission.setTitre(request.getTitre());
        mission.setDatedebut(request.getDatedebut());
        mission.setDatefin(request.getDatefin());
        mission.setMotif(request.getMotif());
        mission.setDescription(request.getDescription());
        mission.setTjm(request.getTjm());
        Mission saved = missionRepository.save(mission);

        MissionResponse missionResponse = new MissionResponse();
        missionResponse.setId(saved.getId());
        missionResponse.setTitre(saved.getTitre());
        missionResponse.setDatedebut(saved.getDatedebut());
        missionResponse.setDatefin(saved.getDatefin());
        missionResponse.setMotif(saved.getMotif());
        missionResponse.setDescription(saved.getDescription());
        missionResponse.setTjm(saved.getTjm());

        return missionResponse;
    }

    //Update Mission
    public MissionResponse updateMission(Long id, MissionRequest request){
      Mission mission = missionRepository.findById(id).orElseThrow(
              ()->new EntityNotFoundException("Mission non trouve pour l'id : " + id));

      mission.setTitre(request.getTitre());
      mission.setDatedebut(request.getDatedebut());
      mission.setDatefin(request.getDatefin());
      mission.setTjm(request.getTjm());
      mission.setDescription(request.getDescription());
      mission.setMotif(request.getMotif());
      Mission saved = missionRepository.save(mission);

        MissionResponse missionResponse = new MissionResponse();
        missionResponse.setId(saved.getId());
        missionResponse.setTitre(saved.getTitre());
        missionResponse.setDatedebut(saved.getDatedebut());
        missionResponse.setDatefin(saved.getDatefin());
        missionResponse.setMotif(saved.getMotif());
        missionResponse.setDescription(saved.getDescription());
        missionResponse.setTjm(saved.getTjm());

      return missionResponse;
    }

    //delete mission
    public void deleteMission(Long id){
        Mission mission = missionRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("Mission non trouve pour l'id : "+id));

        missionRepository.delete(mission);
    }


    //Retrouver une mission
    public MissionResponse getMissionById(Long id){
        Mission mission = missionRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("Mission non trouve pour l'id : "+id));

        MissionResponse missionResponse = new MissionResponse();
        missionResponse.setId(mission.getId());
        missionResponse.setTitre(mission.getTitre());
        missionResponse.setDatedebut(mission.getDatedebut());
        missionResponse.setDatefin(mission.getDatefin());
        missionResponse.setMotif(mission.getMotif());
        missionResponse.setDescription(mission.getDescription());
        missionResponse.setTjm(mission.getTjm());

        return missionResponse;

    }


    //List Mission
    public List<MissionResponse> getAllMissions(){
        List<Mission> missions = missionRepository.findAll();

        List<MissionResponse> listMresponse = new ArrayList<>();

        for (Mission v:missions){
            MissionResponse missionResponse = new MissionResponse();
            missionResponse.setId(v.getId());
            missionResponse.setTitre(v.getTitre());
            missionResponse.setDatedebut(v.getDatedebut());
            missionResponse.setDatefin(v.getDatefin());
            missionResponse.setMotif(v.getMotif());
            missionResponse.setDescription(v.getDescription());
            missionResponse.setTjm(v.getTjm());

            listMresponse.add(missionResponse);
        }

        return listMresponse;
    }
}
