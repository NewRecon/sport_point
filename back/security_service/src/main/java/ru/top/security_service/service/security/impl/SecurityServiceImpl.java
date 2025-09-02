package ru.top.security_service.service.security.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.dto.rs.LoginRs;
import ru.top.security_service.enums.Role;
import ru.top.security_service.service.entity.UserService;
import ru.top.security_service.service.security.JwtService;
import ru.top.security_service.service.security.SecurityService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginRs login(UserData userData) {

        UserData user = userService.getByUsername(userData.getUsername());

        if (passwordEncoder.matches(userData.getPassword(), user.getPassword())) {

            String token = jwtService.generateToken(user);

            System.out.println(token);

            return LoginRs.builder()
                    .accessToken(token)
                    .build();

        } else {
            throw new RuntimeException("Not correct login or password");
        }
    }

    @Override
    public LoginRs register(UserData userData) {

        userData = userData.toBuilder()
                .id(UUID.randomUUID())
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
