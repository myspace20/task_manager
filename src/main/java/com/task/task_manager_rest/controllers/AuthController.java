package com.task.task_manager_rest.controllers;

import com.task.task_manager_rest.dto.CreateUserDto;
import com.task.task_manager_rest.dto.LoginRequestDto;
import com.task.task_manager_rest.dto.LoginResponseDto;
import com.task.task_manager_rest.dto.UserResponseDto;
import com.task.task_manager_rest.service.AuthService;
import com.task.task_manager_rest.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody CreateUserDto createUserDto) {
        UserResponseDto registeredUser = authService.register(createUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto responseDto = authService.login(loginRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}
