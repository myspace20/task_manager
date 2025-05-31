package com.task.task_manager_rest.controllers;

import com.task.task_manager_rest.dto.CreateTaskDto;
import com.task.task_manager_rest.dto.TaskResponseDto;
import com.task.task_manager_rest.dto.TaskUpdateDto;
import com.task.task_manager_rest.service.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponseDto> getAllTasks() {
        return taskService.findAll();
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto>  createTask(@RequestBody CreateTaskDto task) {
        TaskResponseDto createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable Long id, @RequestBody TaskUpdateDto task){
        taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id){
        taskService.delete(id);
    }

}
