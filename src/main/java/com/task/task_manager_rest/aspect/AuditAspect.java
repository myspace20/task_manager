package com.task.task_manager_rest.aspect;

import com.task.task_manager_rest.dto.LoginRequestDto;
import com.task.task_manager_rest.entity.AuditLog;
import com.task.task_manager_rest.infrastructure.database.repositories.postgres.AuditLogRepository;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AuditAspect {

    private final AuditLogRepository auditLogRepository;

    public AuditAspect(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Before("execution(* com.task.task_manager_rest.service.*.*(..)) && args(LoginRequest,..)")
    public void logActivity(Object LoginRequest) {
        String username = "";

        if (LoginRequest instanceof LoginRequestDto dto) {
            username = dto.getUsername();
        }

        AuditLog log = new AuditLog();
        log.setUsername(username);
        log.setAction("LOGIN_ATTEMPT");
        log.setTimestamp(new Date());
        log.setResource("Login");
        log.setDetails("Login attempt by user: " + username);
        auditLogRepository.save(log);
    }
}