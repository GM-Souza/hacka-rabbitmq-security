package com.hackathon.application.dto.userDTO;

public record CreateUserRequest(String name, String email, String password, String role, String setor) {
}
