package ru.top.security_service.service.entity;

import ru.top.security_service.dto.UserData;

public interface UserService {

    UserData getUser(UserData userData);

    void save(UserData userData);
}