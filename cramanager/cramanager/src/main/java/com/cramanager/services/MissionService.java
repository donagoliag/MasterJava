package com.cramanager.services;

import com.cramanager.dto.Mission.MissionRequest;
import com.cramanager.dto.Mission.MissionResponse;

import java.util.List;

public interface MissionService {
    MissionResponse createMission(MissionRequest request);
    MissionResponse updateMission(Long id, MissionRequest request);
    void deleteMission(Long id);
    MissionResponse getMissionById(Long id);
    List<MissionResponse> getAllMissions();
}
