package com.task.task_manager_rest.infrastructure.database.repositories.postgres;

import com.task.task_manager_rest.entity.Task;
import com.task.task_manager_rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title);
}
