package ru.top.security_service.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.top.security_service.enums.Role;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    private UUID userId;
    private String username;
    private String email;
    private String password;
    private Role role;
}
