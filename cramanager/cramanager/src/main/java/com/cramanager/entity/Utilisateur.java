package com.cramanager.entity;



/*
Gestion collaborateurs :

Création
Modification (sauf email)
Activation / désactivation
Champs :
Nom, prénom, email
role (mission / intercontrat)
Contrat (CDI / Indep / Portage)
Séniorité (Junior / Confirmé / Expert)
Salaire (champ libre)
*/

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.StatutContrat;
import com.cramanager.enumeration.UserRoles;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name="utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nom;

    @Column(nullable=false)
    private String prenom;

    @Column(nullable=false, unique = true)
    private Long email;

    @Column(nullable=false)
    private UserRoles role;

    @Column(nullable=false)
    private Contrat contrat;

    @Column(nullable=false)
    private Seniorite seniorité;

    private BigInteger salaire;

    @Column(nullable=false)
    private StatutContrat statut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutContrat getStatut() {
        return statut;
    }

    public void setStatut(StatutContrat statut) {
        this.statut = statut;
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

    public UserRoles getrole() {
        return role;
    }

    public void setrole(UserRoles role) {
        this.role = role;
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
