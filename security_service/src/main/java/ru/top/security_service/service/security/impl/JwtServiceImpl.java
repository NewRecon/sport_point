package ru.top.security_service.service.security.impl;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import ru.top.security_service.service.security.JwtService;

public class JwtServiceImpl implements JwtService {

    @Value("${token.signing.key}")
    private String jwtSigningKey;

    @Override
    public String generateToken(UserDetails user) {

        Claims claims = buildClaims(user);
        Header header = builHeader();
        Key key = getKey(jwtSigningKey);

        return Jwts.builder()
                .header().add(header).and()
                .claims(claims)
                .subject(user.getUsername())
                .expiration(new Date(System.currentTimeMillis() + 100000 * 60 * 24))
                .signWith(key)
                .compact();
    }

    @Override
    public String extractUserName(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractUserName'");
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isTokenValid'");
    }

    private Header builHeader() {
        return Jwts.header().build();
    }

    private Claims buildClaims(UserDetails user) {
        return Jwts.claims().build();
    }

    private Key getKey(String jwtSigningKey) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
