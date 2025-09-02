package ru.top.security_service.service.security.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.service.security.JwtService;

import java.security.Key;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${token.signing.key}")
    private String jwtSigningKey;

    @Override
    public String generateToken(UserData userData) {

        var claims = buildClaims(userData);
        var expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        var key = getKey(jwtSigningKey);

        return Jwts.builder()
                .claims(claims)
                .expiration(expirationDate)
                .signWith(key)
                .compact();
    }

    @Override
    public boolean isTokenValid(String token, UserData userData) {

        try {
            Jwts.parser().build().parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    private Claims buildClaims(UserData user) {
        return Jwts.claims()
                .subject(user.getUsername())
                .add("role", user.getRole())
                .add("email", user.getEmail())
                .add("userId", user.getId())
                .build();
    }

    private Key getKey(String jwtSigningKey) {
        return Keys.hmacShaKeyFor(jwtSigningKey.getBytes());
    }
}
