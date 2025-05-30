package com.task.task_manager_rest.dto;

public class TaskUpdateDto {
        private String title;
        private String description;
        private String status;


        public TaskUpdateDto(String title, String description, String status) {
            this.title = title;
            this.description = description;
            this.status = status;
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

}
