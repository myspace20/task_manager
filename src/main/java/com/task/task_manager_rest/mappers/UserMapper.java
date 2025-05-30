package com.task.task_manager_rest.mappers;

import com.task.task_manager_rest.dto.UserResponseDto;
import com.task.task_manager_rest.entity.User;

public class UserMapper {

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getUsername(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
