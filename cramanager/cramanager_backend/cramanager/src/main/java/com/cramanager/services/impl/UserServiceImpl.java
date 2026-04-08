package com.cramanager.services.impl;

import com.cramanager.dto.User.UpdateRequest;
import com.cramanager.dto.User.UserResponseRequest;
import com.cramanager.entity.User;
import com.cramanager.repository.UserRepository;
import com.cramanager.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username)
                        .orElseThrow(()->new UsernameNotFoundException("User not found"));
            }
        };
    }

    //retourne les infos d'un collab par son id
    public UserResponseRequest getUserById(Long id){

        //  Je retrouve le user par l'Id donnee
        User user = userRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Utilisateur non trouve avec l'id : "+ id));

        //Enregistrer les infos du user dont j'ai besoin un userResponseRequest
        UserResponseRequest userResponseRequest = new UserResponseRequest();
        userResponseRequest.setNom(user.getNom());
        userResponseRequest.setPrenom(user.getPrenom());
        userResponseRequest.setSalaire(user.getSalaire());
        userResponseRequest.setContrat(user.getContrat());
        userResponseRequest.setEmail(user.getEmail());
        userResponseRequest.setSeniorite(user.getSeniorite());
        userResponseRequest.setId(user.getId());
        userResponseRequest.setRoles(user.getRole());
        userResponseRequest.setActive(user.isActive());

        //Retouner le userRseponserequest
        return userResponseRequest;
    }

    //retourne la liste de tous les collabs
    public List<UserResponseRequest> getAllUsers(){

        //Je recupere toute la liste de users de la base de donnee
        List<User> user = userRepository.findAll();

        //Je cree une liste UserResponseRequest qque je vais remplis avec les infos de userResponseRequest
        List<UserResponseRequest> userResponseRequests = new ArrayList<>();

        //Remplissage
        for (User v: user){
            UserResponseRequest userResponseRequest = new UserResponseRequest();
            userResponseRequest.setNom(v.getNom());
            userResponseRequest.setPrenom(v.getPrenom());
            userResponseRequest.setSalaire(v.getSalaire());
            userResponseRequest.setContrat(v.getContrat());
            userResponseRequest.setEmail(v.getEmail());
            userResponseRequest.setSeniorite(v.getSeniorite());
            userResponseRequest.setId(v.getId());
            userResponseRequest.setRoles(v.getRole());
            userResponseRequest.setActive(v.isActive());

            userResponseRequests.add(userResponseRequest);
        }

        //Je retourne la liste
        return userResponseRequests;
    }

    // modifie les champs d'un collab (sauf email) et retourne le collab mis à jour
    public UserResponseRequest updateUser(Long id, UpdateRequest request){

        //retrouver le user
        User user = userRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Utilisateur non trouve avec l'id : "+id));


        //Mettre a jour info user
        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setSalaire(request.getSalaire());
        user.setContrat(request.getContrat());
        user.setSeniorite(request.getSeniorite());
        userRepository.save(user);

        //Recup les info de user dans UserResponseRequest
        UserResponseRequest userResponseRequest = new UserResponseRequest();
        userResponseRequest.setNom(user.getNom());
        userResponseRequest.setPrenom(user.getPrenom());
        userResponseRequest.setSalaire(user.getSalaire());
        userResponseRequest.setContrat(user.getContrat());
        userResponseRequest.setEmail(user.getEmail());
        userResponseRequest.setSeniorite(user.getSeniorite());
        userResponseRequest.setId(user.getId());
        userResponseRequest.setRoles(user.getRole());
        userResponseRequest.setActive(user.isActive());

        return userResponseRequest;
    }

    //bascule active entre true et false (activer ou désactiver le compte)
    public void toggleActive(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Utilisateur non trouve avec l'id : "+id));

        user.setActive(!user.isActive());
        userRepository.save(user);
    }

    //reçoit un token, trouve le user correspondant, met active = true et efface le token
    public void activateAccount(String token){
        User user = userRepository.findByActivationToken(token).orElseThrow(()->new EntityNotFoundException("Utilisateur de ce token non trouve"));

        user.setActive(true);
        user.setActivationToken(null);
        userRepository.save(user);
    }



}
