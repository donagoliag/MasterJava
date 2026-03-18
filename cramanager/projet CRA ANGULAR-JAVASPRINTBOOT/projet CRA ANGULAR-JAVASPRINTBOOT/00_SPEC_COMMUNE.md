
# TP — Application de gestion des CRA (CBX)

Durée recommandée : **4 jours ouvrés**
Public : Développeurs full‑stack / mobile (niveau confirmé)

Objectif : Concevoir une application de gestion des CRA (Compte Rendu d’Activité)
avec 2 rôles : Admin société et Collaborateur.

---

## 🎯 Contexte métier
CBX souhaite internaliser un outil simple de gestion des CRA :
- Validation mensuelle des temps
- Gestion missions et intercontrats
- Traçabilité RH simple
- UX fluide pour les consultants

---

## 👥 Rôles
### Admin société
- Gestion collaborateurs :
  - Création
  - Modification (sauf email)
  - Activation / désactivation
  - Champs :
    - Nom, prénom, email
    - Statut (mission / intercontrat)
    - Contrat (CDI / Indep / Portage)
    - Séniorité (Junior / Confirmé / Expert)
    - Salaire (champ libre)

- Gestion missions :
  - Création / modification / suppression
  - Champs :
    - Titre
    - Date début / fin
    - Description
    - Motif
    - TJM

- Affectation mission → collaborateur

- Validation CRA :
  - Valider
  - Rejeter
  - Invalider
  - Motif obligatoire si rejet/invalidation

---

### Collaborateur
- Activation compte via email (mock autorisé)
- Gestion de ses CRA :
  - Déclaration entre le 22 et 28 du mois
  - Saisie :
    - 1 clic (remplir tout le mois)
    - Ou jour par jour
  - Gestion absences :
    - Congé
    - RTT
    - Maladie

- Règles :
  - CRA validé = non modifiable
  - CRA rejeté = modifiable
  - Hors fenêtre 22–28 :
    - Modifiable uniquement si non validé

---

## 📏 Règles métier obligatoires
1. Fenêtre CRA : 22 → 28 du mois (timezone Europe/Paris)
2. États CRA :
   - DRAFT
   - SUBMITTED
   - APPROVED
   - REJECTED
   - INVALIDATED
3. Si aucune mission :
   → CRA auto en intercontrat
4. Alerte admin si :
   - CRA non soumis au 28

---

## 📦 Livrables attendus
- Repo propre
- README clair
- Données démo
- UX fonctionnelle
- Présentation 10 min (démo)

---

## ⭐ Critères d’évaluation
- Qualité architecture
- Clarté code
- Respect règles métier
- UX
- Qualité README
