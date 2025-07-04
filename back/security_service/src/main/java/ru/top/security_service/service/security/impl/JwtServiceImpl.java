package ru.top.security_service.service.security.impl;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import ru.top.security_service.model.User;
import ru.top.security_service.service.security.JwtService;

public class JwtServiceImpl implements JwtService {

    @Value("${token.signing.key}")
    private String jwtSigningKey;

    @Override
    public String generateToken(User user) {

        var claims = buildClaims(user);
        var expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        var key = getKey(jwtSigningKey);

        return Jwts.builder()
                .claims(claims)
                .expiration(expirationDate)
                .signWith(key)
                .compact();
    }

    @Override
    public boolean isTokenValid(String token, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isTokenValid'");
    }

    private Claims buildClaims(User user) {
        return Jwts.claims()
                .add("userId", user.getUserId())
                .add("user", user.getUsername())
                .add("email", user.getEmail())
                .add("role", user.getRole())
                .build();
    }

    private Key getKey(String jwtSigningKey) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
