package ru.top.security_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import ru.top.security_service.dto.UserData;
import ru.top.security_service.dto.rq.LoginRq;
import ru.top.security_service.dto.rq.RegisterRq;
import ru.top.security_service.model.User;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(UserData userData);

    UserData toData(User user);

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    UserData toData(LoginRq LoginRq);

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "id", ignore = true)
    UserData toData(RegisterRq RegisterRq);
}
