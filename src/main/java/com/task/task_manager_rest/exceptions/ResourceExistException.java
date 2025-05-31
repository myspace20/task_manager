package com.task.task_manager_rest.exceptions;

public class ResourceExistException extends RuntimeException {
  public ResourceExistException(String message) {
    super(message);
  }
}
