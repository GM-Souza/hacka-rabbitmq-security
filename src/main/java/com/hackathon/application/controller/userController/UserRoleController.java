package com.hackathon.application.controller.userController;

import com.hackathon.application.dto.userRoleDTO.CreateUserRoleRequest;
import com.hackathon.application.dto.userRoleDTO.CreateUserRoleResponse;
import com.hackathon.application.entity.userEntity.UserRole;
import com.hackathon.application.mapper.userMapper.UserRoleMapper;
import com.hackathon.application.service.userService.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity<CreateUserRoleResponse> createUserRole(@RequestBody CreateUserRoleRequest createUserRoleDTO) {

        UserRole newRole = userRoleService.createRole(createUserRoleDTO);

        CreateUserRoleResponse createUserRoleResponseDTO = UserRoleMapper.toResponse(newRole);

        return ResponseEntity.status(HttpStatus.CREATED).body(createUserRoleResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CreateUserRoleResponse>> getAllRoles() {
        List<CreateUserRoleResponse> roles = userRoleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
}
