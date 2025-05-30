package com.task.task_manager_rest.service;

import com.task.task_manager_rest.dto.CreateUserDto;
import com.task.task_manager_rest.dto.LoginRequestDto;
import com.task.task_manager_rest.dto.LoginResponseDto;
import com.task.task_manager_rest.dto.UserResponseDto;

public interface IAuthService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
    UserResponseDto register(CreateUserDto createUserDto);
}

