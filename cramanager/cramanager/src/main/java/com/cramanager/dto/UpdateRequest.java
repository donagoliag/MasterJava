package com.cramanager.dto;

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.StatutContrat;
import com.cramanager.enumeration.UserRoles;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateRequest {
    private String nom;
    private String prenom;
    private Contrat contrat;
    private Seniorite seniorite;
    private StatutContrat statut;
    private BigDecimal salaire;
}
