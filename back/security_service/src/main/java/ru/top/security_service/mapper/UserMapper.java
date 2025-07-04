package ru.top.security_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ru.top.security_service.dto.UserData;
import ru.top.security_service.model.User;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(UserData userData);

    UserData toData(User user);
}
