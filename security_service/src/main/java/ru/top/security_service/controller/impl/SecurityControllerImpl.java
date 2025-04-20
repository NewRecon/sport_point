package ru.top.security_service.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import ru.top.security_service.controller.SecurityController;

@RestController
public class SecurityControllerImpl implements SecurityController {

    @Override
    public void login() {
        // TODO Auto-generated method stub
        System.out.println("НУ ПРИВЕТ!");
    }

    @Override
    public void register() {
        // TODO Auto-generated method stub

    }

}
