package com.task.task_manager_rest.service;


import com.task.task_manager_rest.dto.CreateUserDto;
import com.task.task_manager_rest.dto.UserResponseDto;
import com.task.task_manager_rest.entity.User;
import com.task.task_manager_rest.exceptions.NotFoundException;
import com.task.task_manager_rest.infrastructure.database.repositories.postgres.UserRepository;
import com.task.task_manager_rest.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(CreateUserDto user){
        User newUser = new User(user.getUsername(), user.getPassword());
        User createdUser = userRepository.save(newUser);
        return UserMapper.toDto(createdUser);
    }

    public UserResponseDto getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return UserMapper.toDto(user);
    }

    public Optional<User> findByUsername(String username) throws Exception {
        return Optional.ofNullable(userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found: " + username)));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }


}
