package ru.top.security_service.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.top.security_service.controller.SecurityController;
import ru.top.security_service.dto.UserRq;
import ru.top.security_service.service.security.SecurityService;

@RestController
@RequiredArgsConstructor
public class SecurityControllerImpl implements SecurityController {

    private final SecurityService securityService;

    @Override
    public void login(UserRq request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public void register(UserRq request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
