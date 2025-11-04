package com.hackathon.application.mapper.userMapper;

import com.hackathon.application.dto.userRoleDTO.CreateUserRoleRequest;
import com.hackathon.application.dto.userRoleDTO.CreateUserRoleResponse;
import com.hackathon.application.entity.userEntity.UserRole;

public class UserRoleMapper {

    public static UserRole map(final CreateUserRoleRequest createUserRoleRequestDTO) {
        return UserRole.builder()
                .name(createUserRoleRequestDTO.name())
                .build();
    }


    public static CreateUserRoleResponse toResponse(final UserRole userRole){
        return new CreateUserRoleResponse(
                userRole.getId(),
                userRole.getName()
        );
    }
}
