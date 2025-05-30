package com.task.task_manager_rest.controllers;

import com.task.task_manager_rest.dto.CreateTaskDto;
import com.task.task_manager_rest.dto.TaskResponseDto;
import com.task.task_manager_rest.dto.TaskUpdateDto;
import com.task.task_manager_rest.service.ITaskService;
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
    public TaskResponseDto createTask(@RequestBody CreateTaskDto task) {
        System.out.println(task.toString());
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public TaskResponseDto  updateTask(@PathVariable Long id, @RequestBody TaskUpdateDto task){
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.delete(id);
    }

}
