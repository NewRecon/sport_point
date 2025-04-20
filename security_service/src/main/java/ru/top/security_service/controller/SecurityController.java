package ru.top.security_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth")
public interface SecurityController {

    @PostMapping("/login")
    public void login();

    @PostMapping("/register")
    public void register();

}
