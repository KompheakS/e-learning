package com.cambodia.udemy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    public void setStatus(int status) {
        if (status == 0){
            this.status = 0;
        }
    }
}
