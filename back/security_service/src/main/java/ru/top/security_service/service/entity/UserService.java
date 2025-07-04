package ru.top.security_service.service.entity;

import ru.top.security_service.dto.UserData;

public interface UserService {

    UserData getById(String id);

    void save(UserData userData);
}