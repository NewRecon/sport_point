package ru.top.security_service.service.security.impl;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.dto.rs.LoginRs;
import ru.top.security_service.enums.Role;
import ru.top.security_service.model.User;
import ru.top.security_service.service.entity.UserService;
import ru.top.security_service.service.security.JwtService;
import ru.top.security_service.service.security.SecurityService;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginRs login(UserData userData) {

        UserData user = userService.getByUsername(userData.getUsername());

        passwordEncoder.matches(userData.getPassword(), user.getPassword());

        String token = jwtService.generateToken(user);

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
                .password(passwordEncoder.encode(userData.getPassword()))
                .build();

        userService.save(userData);

        String token = jwtService.generateToken(userData);

        return LoginRs.builder()
                .accessToken(token)
                .build();
    }
}
