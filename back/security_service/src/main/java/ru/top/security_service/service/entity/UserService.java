package ru.top.security_service.service.entity;

import ru.top.security_service.dto.UserData;

public interface UserService {

    void save(UserData userData);

    UserData getByUsername(String username);
}