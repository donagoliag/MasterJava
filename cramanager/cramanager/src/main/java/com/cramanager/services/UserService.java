package com.cramanager.services;

import com.cramanager.dto.USER.UpdateRequest;
import com.cramanager.dto.USER.UserResponseRequest;
import com.cramanager.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.webauthn.management.UserCredentialRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDetailsService userDetailsService();
    UserResponseRequest getUserById(Long id);
    List<UserResponseRequest> getAllUsers();
    UserResponseRequest updateUser(Long id, UpdateRequest request);
    void toggleActive(Long id);
    void activateAccount(String token);
}
