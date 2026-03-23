package com.cramanager.services.impl;


import com.cramanager.services.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.antlr.v4.runtime.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {

   public String generationToken(UserDetails userDetails){

      return Jwts.builder()
              .setSubject(userDetails.getUsername())
              .setIssuedAt(new Date(System.currentTimeMillis()))
              .setExpiration(new Date(System.currentTimeMillis()))
              .signWith(getSigninKey(), SignatureAlgorithm.HS256)
              .compact();
   }

   private Key getSigninKey(){
       byte[] key = Decoders.BASE64.decode("${cramanager.secretkey}");
       return Keys.hmacShaKeyFor(key);
   }

   private <T> T extractclaim(String token, Function<Claims, T> claimsResolvers){
       final Claims claims = extractallClaims(token);
       return claimsResolvers.apply(claims);
   }

    private Claims extractallClaims (String token){
        return  Jwts.parser()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUserName (String token){
       return extractclaim(token,Claims::getSubject);
    }

    //On veut checker la validite du token
    public boolean isTokenValide(String token, UserDetails userDetails){
       final String username = extractUserName(token);
       return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired (String token){
       return extractclaim(token, Claims::getExpiration).before(new Date());
    }
}

