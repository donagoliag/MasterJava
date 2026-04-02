package com.cramanager.dto.USER;

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.StatutContrat;
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
