package com.cramanager.entity;

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.EtatCRA;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.UserRoles;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDate;

/*
Gestion missions :

Création / modification / suppression
Champs :
Titre
Date début / fin
Description
Motif
TJM
*/

@Entity
@Table(name="mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String titre;

    @Column(nullable=false)
    private LocalDate DateDebut;

    @Column(nullable=false)
    private LocalDate DateFin;


    private String description;
    private String motif;
    private BigInteger TJM;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        DateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return DateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        DateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public BigInteger getTJM() {
        return TJM;
    }

    public void setTJM(BigInteger TJM) {
        this.TJM = TJM;
    }
}
