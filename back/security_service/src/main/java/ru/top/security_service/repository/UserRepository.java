package ru.top.security_service.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.top.security_service.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findПожалуйстаByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
