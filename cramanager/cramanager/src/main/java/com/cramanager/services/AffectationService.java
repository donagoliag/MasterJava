package com.cramanager.services;

import com.cramanager.dto.affectation.AffectationResponse;

public interface AffectationService {

    void affecter(Long userId, Long missionId);
    void desaffecter(Long userId);
    AffectationResponse getAffectationByUser(Long userId);
}
