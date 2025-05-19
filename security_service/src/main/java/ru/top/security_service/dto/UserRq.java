package ru.top.security_service.dto;

public record UserRq(
                     String id,
                     String username,
                     String email,
                     String password
) {

}