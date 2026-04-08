package com.cramanager.dto.CRA;

import com.cramanager.enumeration.EtatCRA;
import lombok.Data;

@Data
public class CraRequest {
    private Long userId;
    private int mois;
    private int annee;
}
