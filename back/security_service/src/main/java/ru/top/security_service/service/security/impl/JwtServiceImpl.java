package ru.top.security_service.service.security.impl;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.service.security.JwtService;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${token.signing.key}")
    private String jwtSigningKey;

    @Override
    public String generateToken(UserData user) {

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
    public boolean isTokenValid(String token, UserData user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isTokenValid'");
    }

    private Claims buildClaims(UserData user) {
        return Jwts.claims()
                .add("user", user.getUsername())
                .build();
    }

    private Key getKey(String jwtSigningKey) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
