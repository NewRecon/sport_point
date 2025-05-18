package ru.top.security_service.service.security.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.service.entity.UserService;
import ru.top.security_service.service.security.SecurityService;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserService userService;

    @Override
    public void login() {
        // TODO Auto-generated method stub

        UserData user = userService.getById(null);

        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public void register() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
