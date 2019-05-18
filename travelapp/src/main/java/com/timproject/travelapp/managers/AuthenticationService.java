package com.timproject.travelapp.managers;

import com.timproject.travelapp.dao.entities.UserEntity;
import com.timproject.travelapp.dao.repositories.UserRepository;
import com.timproject.travelapp.config.security.TokenAuthenticationService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

public class AuthenticationService {

    private UserRepository userRepository;
    private String secret;
    private String headerString;

    @Autowired
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.secret = TokenAuthenticationService.getSECRET();
        this.headerString = TokenAuthenticationService.getHeaderString();
    }

    private String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


    public boolean authenticate(HttpHeaders httpHeaders, long userId) {
        String token = httpHeaders.getFirst(headerString);
        if (token == null) {
            return false;
        } else {
            String username = getUsernameFromToken(token);
            UserEntity userEntity = userRepository.findByUsername(username);
            return userEntity != null && userEntity.getId() == userId;
        }
    }
}
