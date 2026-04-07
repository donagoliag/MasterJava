package com.cramanager.services.impl;

import com.cramanager.dto.CRA.CraRequest;
import com.cramanager.dto.CRA.CraResponse;
import com.cramanager.dto.CRAJour.CraJourRequest;
import com.cramanager.dto.CRAJour.CraJourResponse;
import com.cramanager.dto.Mission.MissionResponse;
import com.cramanager.entity.*;
import com.cramanager.enumeration.EtatCRA;
import com.cramanager.enumeration.StatutContrat;
import com.cramanager.enumeration.TypeAbsence;
import com.cramanager.repository.AffectationRepository;
import com.cramanager.repository.CraRepository;
import com.cramanager.repository.MissionRepository;
import com.cramanager.repository.UserRepository;
import com.cramanager.services.AffectationService;
import com.cramanager.services.CraService;
import com.cramanager.services.MissionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.cramanager.enumeration.StatutContrat.MISSION;

@Service
@RequiredArgsConstructor
public class CraServiceImpl implements CraService {

    private final CraRepository craRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final AffectationService affectationService;
    private final AffectationRepository affectationRepository;
    private final MissionService missionService;

    // Crée un CRA DRAFT pour un collab pour un mois/année donné. Le cra récupère automatiquement sa mission active sil en a
    public CraResponse creerCRA(CraRequest request){

        //Retrouver le user a partir de son id
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User non trouvé avec lid : " + request.getUserId()));

        //Retrouver La mission a partir du user id
        Mission mission = null;
        if (user.getStatut() == StatutContrat.MISSION) {
            mission = affectationRepository.findByUserId(user.getId())
                    .map(Affectation::getMission)
                    .orElse(null);
        }

        CRA cra = new CRA();
        cra.setUser(user);
        cra.setMission(mission);
        cra.setMois(request.getMois());
        cra.setAnnee(request.getAnnee());
        cra.setEtatCRA(EtatCRA.DRAFT);
        CRA saved = craRepository.save(cra);

        CraResponse craResponse = new CraResponse();
        craResponse.setId(saved.getId());
        craResponse.setUserid(saved.getUser().getId());
        craResponse.setMissionid(mission != null ? mission.getId() : null);
        craResponse.setMois(saved.getMois());
        craResponse.setAnnee(saved.getAnnee());
        craResponse.setEtatCRA(saved.getEtatCRA());
        craResponse.setJours(
                cra.getJours().stream().map(j -> {
                    CraJourResponse jr = new CraJourResponse();
                    jr.setId(j.getId());
                    jr.setCraid(cra.getId());
                    jr.setJour(j.getJour());
                    jr.setType(j.getType());
                    return jr;
                }).collect(Collectors.toList())
        );
        return craResponse;

    }

    // Retourne les infos d'un CRA par son id
    public CraResponse getCRAById(Long craId){

        CRA cra = craRepository.findById(craId).orElseThrow(() -> new EntityNotFoundException("Cra non trouvé avec lid : " + craId));

        CraResponse craResponse = new CraResponse();

        craResponse.setId(craId);
        craResponse.setUserid(cra.getUser().getId());
        craResponse.setMissionid(cra.getMission() != null? cra.getMission().getId() : null);
        craResponse.setMois(cra.getMois());
        craResponse.setAnnee(cra.getAnnee());
        craResponse.setEtatCRA(cra.getEtatCRA());

        craResponse.setJours(
                cra.getJours().stream().map(j -> {
                    CraJourResponse jr = new CraJourResponse();
                    jr.setId(j.getId());
                    jr.setCraid(cra.getId());
                    jr.setJour(j.getJour());
                    jr.setType(j.getType());
                    return jr;
                }).collect(Collectors.toList())
        );

        return craResponse;
    }

    // Retourne tous les CRA d'un collab (historique)
    public List<CraResponse> getCRAByUser(Long userId){
        List<CRA> listCRA = craRepository.findByUserId(userId);

        List<CraResponse> listCraresponse = new ArrayList<>();

        for (CRA v : listCRA){
            CraResponse craResponse = new CraResponse();
            craResponse.setId(v.getId());
            craResponse.setUserid(v.getUser().getId());
            craResponse.setMissionid(v.getMission() != null? v.getMission().getId() : null);
            craResponse.setMois(v.getMois());
            craResponse.setAnnee(v.getAnnee());
            craResponse.setEtatCRA(v.getEtatCRA());

            craResponse.setJours(
                    v.getJours().stream().map(j -> {
                        CraJourResponse jr = new CraJourResponse();
                        jr.setId(j.getId());
                        jr.setCraid(v.getId());
                        jr.setJour(j.getJour());
                        jr.setType(j.getType());
                        return jr;
                    }).collect(Collectors.toList())
            );

            listCraresponse.add(craResponse);
        }

        return listCraresponse;
    }

    // Remplit automatiquement tous les jours ouvrés du mois en TRAVAILLE en 1 clic
    public void remplirMois(Long craId){
        //Retrouver le CRA par id
        CRA cra = craRepository.findById(craId).orElseThrow(() -> new EntityNotFoundException("Cra non trouvé avec lid : " + craId));

        //Vérifier que le statut est DRAFT ou REJECTED, sinon on ne peut pas modifier
        if(cra.getEtatCRA()!=EtatCRA.DRAFT && cra.getEtatCRA()!=EtatCRA.REJETE){
            throw new IllegalStateException("CRA non modifiable avec le statut : " + cra.getEtatCRA());
        }

        cra.getJours().clear();

        //Boucler sur tous les jours du mois, si c'est un lundi-vendredi créer un CRAJour avec type TRAVAILLE
        LocalDate debut = LocalDate.of(cra.getAnnee(),cra.getMois(),1);
        LocalDate fin = debut.withDayOfMonth(debut.lengthOfMonth());

        for (LocalDate date=debut; !date.isAfter(fin); date= date.plusDays(1)){
            //Si c'est un jour ouvree de Lundi a Vendredi
            //Sauvegarder tous les jours
            if (date.getDayOfWeek()!=DayOfWeek.SATURDAY && date.getDayOfWeek()!=DayOfWeek.SUNDAY){
                CRAJour jour = new CRAJour();
                jour.setCra(cra);
                jour.setJour(date);
                jour.setType(TypeAbsence.TRAVAILLE);
                cra.getJours().add(jour);
            }
        }
        craRepository.save(cra);
    }

    // Ajoute ou modifie un jour spécifique (TRAVAILLE, CONGE, RTT, MALADIE)
    public void remplirJour(Long craId, CraJourRequest request) {

        CRA cra = craRepository.findById(craId)
                .orElseThrow(() -> new EntityNotFoundException("CRA non trouvé : " + craId));

        if (cra.getEtatCRA() != EtatCRA.DRAFT && cra.getEtatCRA() != EtatCRA.REJETE) {
            throw new IllegalStateException("CRA non modifiable avec le statut : " + cra.getEtatCRA());
        }

        // Chercher si le jour existe déjà
        CRAJour jour = cra.getJours().stream()
                .filter(j -> j.getJour().equals(request.getJour()))
                .findFirst()
                .orElse(null);

        if (jour == null) {
            // Créer un nouveau jour
            jour = new CRAJour();
            jour.setCra(cra);
            jour.setJour(request.getJour());
            cra.getJours().add(jour);
        }

        // Modifier ou initialiser le type
        jour.setType(request.getType());
        craRepository.save(cra);
    }

    // Collab soumet son CRA → DRAFT à SUBMITTED, vérifie qu'on est entre le 22 et 28
    public void soumettreCRA(Long craId) {

        CRA cra = craRepository.findById(craId)
                .orElseThrow(() -> new EntityNotFoundException("CRA non trouvé : " + craId));

        // Vérifier que le statut est DRAFT ou REJECTED
        if (cra.getEtatCRA() != EtatCRA.DRAFT && cra.getEtatCRA() != EtatCRA.REJETE) {
            throw new IllegalStateException("Impossible de soumettre un CRA avec le statut : " + cra.getEtatCRA());
        }

        // Vérifier qu'on est entre le 22 et 28 du mois (timezone Paris)
        LocalDate today = LocalDate.now(ZoneId.of("Europe/Paris"));
        if (today.getDayOfMonth() < 6 || today.getDayOfMonth() > 28) {
            throw new IllegalStateException("La soumission n'est autorisée qu'entre le 22 et le 28 du mois");
        }

        cra.setEtatCRA(EtatCRA.SOUMIS);
        craRepository.save(cra);
    }

    // Admin valide → SUBMITTED à APPROVED, CRA non modifiable après
    public void validerCRA(Long craId) {

        CRA cra = craRepository.findById(craId)
                .orElseThrow(() -> new EntityNotFoundException("CRA non trouvé : " + craId));

        if (cra.getEtatCRA() != EtatCRA.SOUMIS) {
            throw new IllegalStateException("Impossible de valider un CRA avec le statut : " + cra.getEtatCRA());
        }

        cra.setEtatCRA(EtatCRA.APPROUVE);
        craRepository.save(cra);
    }

    // Admin rejette → SUBMITTED à REJECTED, motif obligatoire, redevient modifiable
    public void rejeterCRA(Long craId, String motif) {

        CRA cra = craRepository.findById(craId)
                .orElseThrow(() -> new EntityNotFoundException("CRA non trouvé : " + craId));

        if (cra.getEtatCRA() != EtatCRA.SOUMIS) {
            throw new IllegalStateException("Impossible de rejeter un CRA avec le statut : " + cra.getEtatCRA());
        }

        if (motif == null || motif.isBlank()) {
            throw new IllegalArgumentException("Le motif est obligatoire pour rejeter un CRA");
        }

        cra.setEtatCRA(EtatCRA.REJETE);
        cra.setMotifRejet(motif);
        craRepository.save(cra);
    }

    // Admin invalide → APPROVED à INVALIDATED, motif obligatoire
    public void invaliderCRA(Long craId, String motif) {

        CRA cra = craRepository.findById(craId)
                .orElseThrow(() -> new EntityNotFoundException("CRA non trouvé : " + craId));

        if (cra.getEtatCRA() != EtatCRA.APPROUVE) {
            throw new IllegalStateException("Impossible d'invalider un CRA avec le statut : " + cra.getEtatCRA());
        }

        if (motif == null || motif.isBlank()) {
            throw new IllegalArgumentException("Le motif est obligatoire pour invalider un CRA");
        }

        cra.setEtatCRA(EtatCRA.INVALIDE);
        cra.setMotifRejet(motif);
        craRepository.save(cra);
    }

    // Retourne tous les CRA non soumis pour un mois/année donné
    public List<CraResponse> getCraNonSoumis(int mois, int annee) {

        List<CRA> crasNonSoumis = craRepository.findByMoisAndAnneeAndEtatCRANot(mois, annee, EtatCRA.SOUMIS);

        List<CraResponse> listCraResponse = new ArrayList<>();

        for (CRA v : crasNonSoumis) {
            CraResponse craResponse = new CraResponse();
            craResponse.setId(v.getId());
            craResponse.setUserid(v.getUser().getId());
            craResponse.setMissionid(v.getMission() != null ? v.getMission().getId() : null);
            craResponse.setMois(v.getMois());
            craResponse.setAnnee(v.getAnnee());
            craResponse.setEtatCRA(v.getEtatCRA());
            craResponse.setJours(
                    v.getJours().stream().map(j -> {
                        CraJourResponse jr = new CraJourResponse();
                        jr.setId(j.getId());
                        jr.setCraid(v.getId());
                        jr.setJour(j.getJour());
                        jr.setType(j.getType());
                        return jr;
                    }).collect(Collectors.toList())
            );
            listCraResponse.add(craResponse);
        }

        return listCraResponse;
    }
}
