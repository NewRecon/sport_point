package ru.top.profile_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/profiles")
public interface ProfileController {

    @GetMapping("/{id}")
    void getById();
}