package ru.top.security_service.enums;

import org.springframework.security.core.GrantedAuthority;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {

    USER("USER"),
    ADMIN("ADMIN");

    private final String value;

    @Override
    public String getAuthority() {
        return value;
    }
}
