package com.cramanager.entity;


/*
Validation CRA :

Valider
Rejeter
Invalider
Motif obligatoire si rejet/invalidation

Collaborateur
Activation compte via email (mock autorisé)

Gestion de ses CRA :

Déclaration entre le 22 et 28 du mois
Saisie :
1 clic (remplir tout le mois)
Ou jour par jour
Gestion absences :
Congé
RTT
Maladie
Règles :

CRA validé = non modifiable
CRA rejeté = modifiable
Hors fenêtre 22–28 :
Modifiable uniquement si non validé
*/

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.EtatCRA;
import com.cramanager.enumeration.StatutContrat;
import com.cramanager.enumeration.TypeAbsence;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Data
@Entity
@Table(name = "CRA")
public class CRA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EtatCRA etatCRA;

    @ManyToOne
    @JoinColumn(name="mission_id",nullable = true)
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(nullable = false)
    private int mois;

    @Column(nullable = false)
    private int annee;

    private String motifRejet;

}
