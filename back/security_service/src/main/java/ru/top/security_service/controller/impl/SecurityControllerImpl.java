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
        securityService.login();
    }

    @Override
    public void register(UserRq request) {
        securityService.register();
    }

    @Override
    public void update() {
        securityService.update();
    }

}
