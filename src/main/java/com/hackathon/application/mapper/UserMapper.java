package com.hackathon.application.mapper;

import com.hackathon.application.dto.userDTO.CreateUserRequest;
import com.hackathon.application.dto.userDTO.CreateUserResponse;
import com.hackathon.application.entity.User;

public class UserMapper {

    public static User map(final CreateUserRequest userDTO) {
        return User.builder()
                .name(userDTO.name())
                .email(userDTO.email())
                .password(userDTO.password())
                .setor(userDTO.setor())
                .build();
    }

    public static CreateUserResponse toResponse(final User user){
        return new CreateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getSetor()
        );
    }
}
