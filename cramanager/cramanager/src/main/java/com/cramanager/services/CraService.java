package com.cramanager.services;


import com.cramanager.dto.CRA.CraRequest;
import com.cramanager.dto.CRA.CraResponse;
import com.cramanager.dto.CRAJour.CraJourRequest;

import java.util.List;

public interface CraService {

    CraResponse creerCRA(CraRequest request);
    CraResponse getCRAById(Long craId);
    List<CraResponse> getCRAByUser(Long userId);
    void remplirMois(Long craId);
    void remplirJour(Long craId, CraJourRequest request);
    void soumettreCRA(Long craId);
    void validerCRA(Long craId);
    void rejeterCRA(Long craId, String motif);
    void invaliderCRA(Long craId, String motif);

}
