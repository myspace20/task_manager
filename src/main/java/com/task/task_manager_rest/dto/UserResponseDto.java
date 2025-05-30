package com.task.task_manager_rest.dto;

import java.time.Instant;

public class UserResponseDto {

    private String username;
    private Instant createdAt;
    private Instant updatedAt;


    public UserResponseDto(String username, Instant createdAt, Instant updatedAt) {
        this.username = username;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
