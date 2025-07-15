package ru.top.security_service.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.top.security_service.controller.SecurityController;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.dto.rq.LoginRq;
import ru.top.security_service.dto.rq.RegisterRq;
import ru.top.security_service.dto.rs.LoginRs;
import ru.top.security_service.mapper.UserMapper;
import ru.top.security_service.service.security.SecurityService;

@RestController
@RequiredArgsConstructor
public class SecurityControllerImpl implements SecurityController {

    private final SecurityService securityService;
    private final UserMapper userMapper;

    @Override
    public LoginRs login(LoginRq request) {
        UserData data = userMapper.toData(request);
        return securityService.login(data);
    }

    @Override
    public LoginRs register(RegisterRq request) {
        UserData data = userMapper.toData(request);
        return securityService.register(data);
    }
}
