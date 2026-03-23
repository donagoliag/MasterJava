package com.cramanager.services;


import com.cramanager.dto.InscriptionRequest;
import com.cramanager.entity.User;

public interface AuthentificationService {

    User inscription(InscriptionRequest inscriptionRequest);

}
