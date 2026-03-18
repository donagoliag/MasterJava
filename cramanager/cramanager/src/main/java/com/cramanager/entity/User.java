package com.cramanager.entity;



/*
Gestion collaborateurs :

Création
Modification (sauf email)
Activation / désactivation
Champs :
Nom, prénom, email
Statut (mission / intercontrat)
Contrat (CDI / Indep / Portage)
Séniorité (Junior / Confirmé / Expert)
Salaire (champ libre)
*/

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.UserRoles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigInteger;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Long email;
    private UserRoles statut;
    private Contrat contrat;
    private Seniorite seniorité;
    private BigInteger salaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getEmail() {
        return email;
    }

    public void setEmail(Long email) {
        this.email = email;
    }

    public UserRoles getStatut() {
        return statut;
    }

    public void setStatut(UserRoles statut) {
        this.statut = statut;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Seniorite getSeniorité() {
        return seniorité;
    }

    public void setSeniorité(Seniorite seniorité) {
        this.seniorité = seniorité;
    }

    public BigInteger getSalaire() {
        return salaire;
    }

    public void setSalaire(BigInteger salaire) {
        this.salaire = salaire;
    }
}
