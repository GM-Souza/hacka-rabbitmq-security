package com.hackathon.application.service;

import com.hackathon.application.dto.userRoleDTO.CreateUserRoleRequest;
import com.hackathon.application.dto.userRoleDTO.CreateUserRoleResponse;
import com.hackathon.application.entity.UserRole;
import com.hackathon.application.mapper.UserRoleMapper;
import com.hackathon.application.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRole createRole(CreateUserRoleRequest createUserRoleDTO) {
        UserRole role = UserRoleMapper.map(createUserRoleDTO);

        return userRoleRepository.save(role);
    }

    public List<CreateUserRoleResponse> getAllRoles() {

        return userRoleRepository.findAll().stream()
                .map(UserRoleMapper::toResponse)
                .collect(toList());
    }
}
