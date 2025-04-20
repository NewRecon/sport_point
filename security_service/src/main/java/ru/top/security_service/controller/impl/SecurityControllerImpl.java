package ru.top.security_service.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import ru.top.security_service.controller.SecurityController;

@RestController
public class SecurityControllerImpl implements SecurityController {

    @Override
    public String getMethodName() {
        return null;
    }

}
