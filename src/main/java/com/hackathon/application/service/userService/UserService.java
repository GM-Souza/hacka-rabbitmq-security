package com.hackathon.application.service.userService;

import com.hackathon.application.dto.userDTO.CreateUserRequest;
import com.hackathon.application.dto.userDTO.CreateUserResponse;
import com.hackathon.application.entity.userEntity.User;
import com.hackathon.application.entity.userEntity.UserRole;
import com.hackathon.application.mapper.userMapper.UserMapper;
import com.hackathon.application.repository.userRepository.UserRepository;
import com.hackathon.application.repository.userRepository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserResponse createUser(CreateUserRequest createUserRequestDTO) {
        User user = UserMapper.map(createUserRequestDTO);
        user.setPassword(passwordEncoder.encode(createUserRequestDTO.password()));

        UserRole role = userRoleRepository.findByName(createUserRequestDTO.role())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);

        userRepository.save(user);
        return UserMapper.toResponse(user);
    }

    public CreateUserResponse getUserById(UUID userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toResponse(user);
    }

    public List<CreateUserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .collect(toList());

    }

    public void deleteUserById(UUID userId){
        userRepository.deleteById(userId);
    }
}
