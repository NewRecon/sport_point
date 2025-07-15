package ru.top.security_service.dto.rq;

import lombok.Builder;

@Builder
public record LoginRq(
        String username,
        String password) {
}