package com.cramanager.services;

import com.cramanager.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.webauthn.management.UserCredentialRepository;
import org.springframework.stereotype.Service;


public interface UserService {
    UserDetailsService userDetailsService();
}
