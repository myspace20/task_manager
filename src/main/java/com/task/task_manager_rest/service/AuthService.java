package com.task.task_manager_rest.service;

import com.task.task_manager_rest.dto.CreateUserDto;
import com.task.task_manager_rest.dto.LoginRequestDto;
import com.task.task_manager_rest.dto.LoginResponseDto;
import com.task.task_manager_rest.dto.UserResponseDto;
import com.task.task_manager_rest.entity.User;
import com.task.task_manager_rest.infrastructure.database.repositories.postgres.UserRepository;
import com.task.task_manager_rest.mappers.UserMapper;
import com.task.task_manager_rest.util.JWTUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    private final LoginMetricService loginMetricService;


    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JWTUtil jwtUtil, LoginMetricService loginMetricService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.loginMetricService = loginMetricService;
    }


    public UserResponseDto register(CreateUserDto createUserDto) {
        if (userRepository.findByUsername(createUserDto.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        String hashedPassword = passwordEncoder.encode(createUserDto.getPassword());

        User user = new User(createUserDto.getUsername(), hashedPassword);
        User savedUser = userRepository.save(user);

        return UserMapper.toDto(savedUser);
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        System.out.println(loginRequestDto);
        Optional<User> userOpt = userRepository.findByUsername(loginRequestDto.getUsername());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("Invalid username or password");
        }
        User user = userOpt.get();
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        String token = jwtUtil.generateToken(user.getId(),user.getUsername());
        loginMetricService.incrementCustomMetric();
        return new LoginResponseDto(user.getUsername(), token);
    }

   }
