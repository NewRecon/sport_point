package ru.top.security_service.service.security.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.service.entity.UserService;
import ru.top.security_service.service.security.JwtService;
import ru.top.security_service.service.security.SecurityService;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserService userService;
    private final JwtService jwtService;

    @Override
    public void login() {

        UserData user = userService.getById(null);

        System.out.println(user);

        // jwtService.generateToken(user);
    }

    @Override
    public void register() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
