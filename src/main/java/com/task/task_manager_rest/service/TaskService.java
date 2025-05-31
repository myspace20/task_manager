package com.task.task_manager_rest.service;


import com.task.task_manager_rest.dto.CreateTaskDto;
import com.task.task_manager_rest.dto.TaskResponseDto;
import com.task.task_manager_rest.dto.TaskUpdateDto;
import com.task.task_manager_rest.entity.Task;
import com.task.task_manager_rest.entity.User;
import com.task.task_manager_rest.exceptions.NotFoundException;
import com.task.task_manager_rest.infrastructure.database.repositories.postgres.TaskRepository;
import com.task.task_manager_rest.infrastructure.database.repositories.postgres.UserRepository;
import com.task.task_manager_rest.mappers.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;
    private  final UserRepository userRepository;


    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskResponseDto createTask(CreateTaskDto task) {
        User user = userRepository.findById(task.getUser_id()).orElseThrow(()-> new NotFoundException("User not found"));
        Task newTask = new Task(task.getTitle(), task.getDescription(),task.getStatus(),user);
        Task createdTask =  taskRepository.save(newTask);
        return TaskMapper.toDto(createdTask);
    }

    public List<TaskResponseDto> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(()-> new NotFoundException("Task not found"));
    }

    public void delete(Long id) {
        this.findById(id);
        taskRepository.deleteById(id);
    }

    public TaskResponseDto update(Long id, TaskUpdateDto task) {
        Task taskTobeUpdated = this.findById(id);
        taskTobeUpdated.setTitle(task.getTitle());
        taskTobeUpdated.setDescription(task.getDescription());
        taskTobeUpdated.setStatus(task.getStatus());
        Task updatedTask = taskRepository.save(taskTobeUpdated);
        return TaskMapper.toDto(updatedTask);
    }

    public Optional<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }
}
