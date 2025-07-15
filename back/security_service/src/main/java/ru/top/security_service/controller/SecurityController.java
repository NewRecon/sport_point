package ru.top.security_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.top.security_service.dto.rq.LoginRq;
import ru.top.security_service.dto.rq.RegisterRq;
import ru.top.security_service.dto.rs.LoginRs;

@RequestMapping("/api/v1/auth")
public interface SecurityController {

    @PostMapping("/login")
    public LoginRs login(@RequestBody LoginRq request);

    @PostMapping("/register")
    public LoginRs register(@RequestBody RegisterRq request);
}
