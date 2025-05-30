package com.task.task_manager_rest.service;

import com.task.task_manager_rest.dto.CreateUserDto;
import com.task.task_manager_rest.dto.UserResponseDto;
import com.task.task_manager_rest.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserResponseDto createUser(CreateUserDto user);
    UserResponseDto getUserById(Long id);
    Optional<User> findByUsername(String username) throws Exception;
    List<User> findAll();
}
