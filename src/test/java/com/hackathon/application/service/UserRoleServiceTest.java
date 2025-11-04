package com.hackathon.application.service;

import com.hackathon.application.dto.userRoleDTO.CreateUserRoleRequest;
import com.hackathon.application.entity.userEntity.UserRole;
import com.hackathon.application.repository.userRepository.UserRoleRepository;
import com.hackathon.application.service.userService.UserRoleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserRoleServiceTest {

    @Mock
    private UserRoleRepository userRoleRepository;

    @InjectMocks
    private UserRoleService userRoleService;

    @Nested
    class createRole {

        @Test
        @DisplayName("Deve criar um novo cargo com sucesso.")
        void shouldCreateARole(){

            var role = new UserRole(
                Long.parseLong("1000"),
                    "TestRole"
            );

            // Return a non-null value to satisfy assertNotNull
            doReturn(role).when(userRoleRepository).save(any());

            var input = new CreateUserRoleRequest(
                    "TestRole"
            );

            var output = userRoleService.createRole(input);

            assertNotNull(output);
            assertEquals("TestRole", output.getName());
            assertEquals(1000L, output.getId());
        }
    }
}