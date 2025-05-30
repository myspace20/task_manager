package com.task.task_manager_rest.infrastructure.database.repositories.postgres;

import com.task.task_manager_rest.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}