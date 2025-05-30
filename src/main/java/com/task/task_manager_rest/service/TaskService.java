package com.task.task_manager_rest.service;


import com.task.task_manager_rest.dto.CreateTaskDto;
import com.task.task_manager_rest.dto.TaskResponseDto;
import com.task.task_manager_rest.dto.TaskUpdateDto;
import com.task.task_manager_rest.entity.Task;
import com.task.task_manager_rest.entity.User;
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
        User user = userRepository.findById(task.getUser_id()).orElseThrow();
        Task newTask = new Task(task.getTitle(), task.getDescription(),task.getStatus(),user);
        Task createdTask =  taskRepository.save(newTask);
        return TaskMapper.toDto(createdTask);
    }

    public List<TaskResponseDto> findAll() {
        return taskRepository.findAll()
                .stream()
                .map((task)->TaskMapper.toDto(task))
                .collect(Collectors.toList());
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));
        taskRepository.deleteById(id);
    }

    public TaskResponseDto update(Long id, TaskUpdateDto task) {
        Task taskTobeupdated = taskRepository.findById(id).orElse(null);
        taskTobeupdated.setTitle(task.getTitle());
        taskTobeupdated.setDescription(task.getDescription());
        taskTobeupdated.setStatus(task.getStatus());
        Task updatedTaks = taskRepository.save(taskTobeupdated);
        return TaskMapper.toDto(updatedTaks);
    }

    public Optional<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }
}
