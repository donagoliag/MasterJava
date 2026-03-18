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

import com.cramanager.enumeration.EtatCRA;
import com.cramanager.enumeration.StatutContrat;
import com.cramanager.enumeration.TypeAbsence;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Entity
@Table(name = "CRA")
public class CRA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private YearMonth mois;

    @Column(nullable = false)
    private EtatCRA etatCRA;

    @Column(nullable = false)
    private String motif_rejet_invalidation;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dateEtat;

    @Column(nullable = false)
    private StatutContrat Typecontrat;

    private TypeAbsence typeAbsence;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public YearMonth getMois() {
        return mois;
    }

    public void setMois(YearMonth mois) {
        this.mois = mois;
    }

    public EtatCRA getEtatCRA() {
        return etatCRA;
    }

    public void setEtatCRA(EtatCRA etatCRA) {
        this.etatCRA = etatCRA;
    }

    public String getMotif_rejet_invalidation() {
        return motif_rejet_invalidation;
    }

    public void setMotif_rejet_invalidation(String motif_rejet_invalidation) {
        this.motif_rejet_invalidation = motif_rejet_invalidation;
    }

    public LocalDateTime getDateEtat() {
        return dateEtat;
    }

    public void setDateEtat(LocalDateTime dateEtat) {
        this.dateEtat = dateEtat;
    }

    public StatutContrat getTypecontrat() {
        return Typecontrat;
    }

    public void setTypecontrat(StatutContrat typecontrat) {
        Typecontrat = typecontrat;
    }
}
