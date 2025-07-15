package ru.top.security_service.service.security;

import ru.top.security_service.dto.UserData;
import ru.top.security_service.dto.rs.LoginRs;

public interface SecurityService {

    LoginRs login(UserData userData);

    LoginRs register(UserData userData);
}
