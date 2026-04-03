package com.cramanager.dto.CRA;

import com.cramanager.dto.CRAJour.CraJourResponse;
import com.cramanager.entity.Mission;
import com.cramanager.entity.User;
import com.cramanager.enumeration.EtatCRA;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CraResponse {

    private Long id;
    private EtatCRA etatCRA;
    private Long missionid;
    private Long userid;
    private int mois;
    private int annee;
    private String motifRejet;
    private List<CraJourResponse> jours;

}
