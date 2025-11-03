package com.hackathon.application.controller;

import com.hackathon.application.dto.userDTO.CreateUserRequest;
import com.hackathon.application.dto.userDTO.CreateUserResponse;
import com.hackathon.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequestDTO) {
        CreateUserResponse newUser = userService.createUser(createUserRequestDTO);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping
    public ResponseEntity<List<CreateUserResponse>> getUsers() {
        List<CreateUserResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateUserResponse> getUserById(@PathVariable UUID id) {
        var user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
