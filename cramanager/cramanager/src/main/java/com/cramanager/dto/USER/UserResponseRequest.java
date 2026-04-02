package com.cramanager.dto.USER;

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.StatutContrat;
import com.cramanager.enumeration.UserRoles;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserResponseRequest {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Contrat contrat;
    private Seniorite seniorite;
    private StatutContrat statut;
    private BigDecimal salaire;
    private UserRoles roles;
    private boolean active;          // ← activation compte
}
