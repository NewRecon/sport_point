package ru.top.security_service.service.security.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.dto.rs.LoginRs;
import ru.top.security_service.enums.Role;
import ru.top.security_service.service.entity.UserService;
import ru.top.security_service.service.security.JwtService;
import ru.top.security_service.service.security.SecurityService;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserService userService;
    private final JwtService jwtService;

    @Override
    public LoginRs login(UserData userData) {

        userData = userService.getUser(userData);

        String token = createToken(userData);

        System.out.println(token);

        return LoginRs.builder()
                .accessToken(token)
                .build();
    }

    @Override
    public LoginRs register(UserData userData) {

        userData = userData.toBuilder()
                .userId(UUID.randomUUID())
                .role(Role.USER)
                .build();

        userService.save(userData);

        String token = createToken(userData);

        return LoginRs.builder()
                .accessToken(token)
                .build();
    }

    private String createToken(UserData userData) {
        return jwtService.generateToken(userData);
    }
}
