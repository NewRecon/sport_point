package ru.top.security_service.service.entity.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.mapper.UserMapper;
import ru.top.security_service.repository.UserRepository;
import ru.top.security_service.service.entity.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void save(UserData userData) {
        userRepository.save(userMapper.toEntity(userData));
    }

    @Override
    public UserData getByUsername(String username) {
        return userMapper.toData(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден")));
    }
}