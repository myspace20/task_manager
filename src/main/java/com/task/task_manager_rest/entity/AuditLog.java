package com.task.task_manager_rest.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "audit_logs")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String action;
    @Column(nullable = false)
    private Date timestamp;
    @Column(nullable = false)
    private String resource;
    @Column(nullable = false)
    private String details;

    public Long getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getResource() {
        return resource;
    }

    public String getDetails() {
        return details;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setAction(String action) {
        this.action = action;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}