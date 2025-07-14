package ru.top.security_service.service.entity.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.exception.UserNotFoundException;
import ru.top.security_service.mapper.UserMapper;
import ru.top.security_service.model.User;
import ru.top.security_service.repository.UserRepository;
import ru.top.security_service.service.entity.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    @Override
    public UserData getById(String id) {
        User user = repository.findПожалуйстаByUsername(id)
                .orElseThrow(() -> new UserNotFoundException("User not found " + id));

        return userMapper.toData(user);
    }

    @Override
    public void save(UserData userData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}