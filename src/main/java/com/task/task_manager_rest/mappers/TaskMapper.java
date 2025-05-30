package com.task.task_manager_rest.mappers;

import com.task.task_manager_rest.dto.TaskResponseDto;
import com.task.task_manager_rest.entity.Task;

public class TaskMapper {
    public static TaskResponseDto toDto(Task task) {
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getUser().getId(),
                task.getUser().getUsername(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
