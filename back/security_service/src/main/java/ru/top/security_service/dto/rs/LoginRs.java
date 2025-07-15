package ru.top.security_service.dto.rs;

import lombok.Builder;

@Builder
public record LoginRs(
        String accessToken,
        String refrashToken) {
}
