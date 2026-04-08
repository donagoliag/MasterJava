package com.cramanager.services;
import com.cramanager.services.impl.JWTServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {

    String extractUserName(String token);
    String generationToken(UserDetails userDetails);
    boolean isTokenValide(String token, UserDetails userDetails);
    String generateRefreshToken(Map<String,Object> extraClaims, UserDetails userDetails);

}
