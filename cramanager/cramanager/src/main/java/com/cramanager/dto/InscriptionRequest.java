package com.cramanager.dto;

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.StatutContrat;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class InscriptionRequest {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Contrat contrat;
    private Seniorite seniorite;
    private StatutContrat statut;
    private BigDecimal salaire;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Seniorite getSeniorite() {
        return seniorite;
    }

    public void setSeniorite(Seniorite seniorite) {
        this.seniorite = seniorite;
    }

    public StatutContrat getStatut() {
        return statut;
    }

    public void setStatut(StatutContrat statut) {
        this.statut = statut;
    }

    public BigDecimal getSalaire() {
        return salaire;
    }

    public void setSalaire(BigDecimal salaire) {
        this.salaire = salaire;
    }
}