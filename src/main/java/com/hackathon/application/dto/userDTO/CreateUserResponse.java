package com.hackathon.application.dto.userDTO;

import com.hackathon.application.entity.userEntity.UserRole;

import java.util.UUID;

public record CreateUserResponse(UUID id, String name, String email, UserRole role, String setor) {

}
