package com.task.task_manager_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTaskDto {

        @NotBlank(message = "Title is required")
        @Size(max = 255,message = "Title cannot exceed 255 characters")
        private String title;

        @NotBlank(message = "Description is required")
        @Size(max = 1000,message = "Description cannot exceed 1000 characters")
        private String description;


        @NotBlank(message = "Status is required")
        @Size(max = 50,message = "Status cannot exceed 50 characters")
        private String status;

        @NotBlank(message = "User id is required")
        private Long user_id;


        public CreateTaskDto(String title, String description, String status, Long user_id) {
            this.title = title;
            this.description = description;
            this.status = status;
            this.user_id = user_id;
        }

        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }

        public Long getUser_id() {
            return user_id;
        }
        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

}
