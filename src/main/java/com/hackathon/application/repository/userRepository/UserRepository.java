package com.hackathon.application.repository.userRepository;

import com.hackathon.application.entity.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <User, UUID> {
    Optional<User> findUserByEmail(String email);
}
