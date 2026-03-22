package com.cramanager.services;
import com.cramanager.services.impl.JWTServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    String extractUserName(String token);
    String generationToken(UserDetails userDetails);
    boolean isTokenValide(String token, UserDetails userDetails);
}
