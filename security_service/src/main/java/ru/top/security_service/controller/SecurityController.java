package ru.top.security_service.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.top.security_service.dto.UserRq;

@RequestMapping("/api/v1/auth")
public interface SecurityController {

    @PostMapping("/login")
    public void login(@RequestBody UserRq request);

    @PostMapping("/register")
    public void register(@RequestBody UserRq request);

    @PatchMapping("/update")
    public void update();

}
