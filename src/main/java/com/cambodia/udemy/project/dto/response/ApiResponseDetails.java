package com.cambodia.udemy.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseDetails<T>{
    private int status;
    private String message;
    private T data;

    public void setStatus(int status) {
        if (status == 0){
            this.status = 0;
        }
    }
}
