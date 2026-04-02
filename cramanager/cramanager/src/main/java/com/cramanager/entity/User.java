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
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name="utilisateurs")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true, updatable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoles role;

    @Enumerated(EnumType.STRING)
    private Contrat contrat;

    @Enumerated(EnumType.STRING)
    private Seniorite seniorite;

    private BigDecimal salaire;

    @Enumerated(EnumType.STRING)
    private StatutContrat statut;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active = false;          // ← activation compte

    @Column(unique = true)
    private String activationToken;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}