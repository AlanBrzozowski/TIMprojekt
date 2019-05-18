package com.timproject.travelapp.config.security;

import com.timproject.travelapp.managers.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;


public class TokenAuthenticationService {

    private static final long EXPIRATION = 864_000_000;
    private static final String SECRET = "TIM_Brzozowski_Jaczynski";
    private static final String HEADER_STRING = "Token";

    public static String getSECRET() {
        return SECRET;
    }

    public static String getHeaderString() {
        return HEADER_STRING;
    }

    static void addAuthentication(HttpServletResponse res, String username, UserService userService) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, JWT);
        res.addHeader("UserId", userService.getUserIdByUsername(username));
        res.addHeader("Admin", userService.isAdminToString(username));
    }

    static Authentication getAuthentication(HttpServletRequest request, UserService userService) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            String user;
            try {
                user = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
            } catch (ExpiredJwtException e) {
                return null;
            }
            if (request.getRequestURL().toString().contains("/admin/") && !userService.isAdmin(user)) {
                return null;
            } else {
                if (userService.isActive(user)) {
                    return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}