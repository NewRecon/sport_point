package ru.top.security_service.service.security;

import ru.top.security_service.dto.UserData;

public interface JwtService {

    /**
     * Генерация токена
     *
     * @param userDetails данные пользователя
     * @return токен
     */
    public String generateToken(UserData userDetails);

    /**
     * Проверка токена на валидность
     *
     * @param token       токен
     * @param userDetails данные пользователя
     * @return true, если токен валиден
     */
    public boolean isTokenValid(String token, UserData userDetails);
}