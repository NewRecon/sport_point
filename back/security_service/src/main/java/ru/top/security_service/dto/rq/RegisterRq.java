package ru.top.security_service.dto.rq;

import lombok.Builder;

@Builder
public record RegisterRq(
        String username,
        String email,
        String password) {
}
