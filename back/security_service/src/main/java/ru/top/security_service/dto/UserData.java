package ru.top.security_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.top.security_service.enums.Role;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    private UUID id;
    private String username;
    private String email;
    private String password;
    private Role role;
}
