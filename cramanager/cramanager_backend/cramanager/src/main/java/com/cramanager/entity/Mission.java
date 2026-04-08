package com.cramanager.entity;

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.EtatCRA;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.UserRoles;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
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

@Data
@Entity
@Table(name="mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String titre;

    @Column(nullable=false)
    private LocalDate datedebut;

    @Column(nullable=true)
    private LocalDate datefin;

    @Column(nullable=true)
    private String description;

    @Column(nullable=true)
    private String motif;

    @Column(nullable=true)
    private BigDecimal tjm;

}
