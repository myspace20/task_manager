package com.task.task_manager_rest.service;

import com.task.task_manager_rest.dto.CreateTaskDto;
import com.task.task_manager_rest.dto.TaskResponseDto;
import com.task.task_manager_rest.dto.TaskUpdateDto;
import com.task.task_manager_rest.entity.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    void delete(Long id);
    List<TaskResponseDto> findAll();
    Task findById(Long id);
    TaskResponseDto createTask(CreateTaskDto task);
    TaskResponseDto update(Long id, TaskUpdateDto task);
    Optional<Task> findByTitle(String title);
}
