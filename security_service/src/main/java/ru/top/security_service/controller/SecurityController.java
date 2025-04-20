package ru.top.security_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth")
public interface SecurityController {

    @GetMapping("/get")
    public String getMethodName();

}
