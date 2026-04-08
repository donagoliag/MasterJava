package com.cramanager.services;

import com.cramanager.dto.User.UpdateRequest;
import com.cramanager.dto.User.UserResponseRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService {
    UserDetailsService userDetailsService();
    UserResponseRequest getUserById(Long id);
    List<UserResponseRequest> getAllUsers();
    UserResponseRequest updateUser(Long id, UpdateRequest request);
    void toggleActive(Long id);
    void activateAccount(String token);
}
