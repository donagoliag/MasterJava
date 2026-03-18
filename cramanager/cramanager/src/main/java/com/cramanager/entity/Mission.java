package com.cramanager.entity;

import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.UserRoles;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private LocalDate DateDebut;
    private LocalDate DateFin;
    private String description;
    private String motif;
}
