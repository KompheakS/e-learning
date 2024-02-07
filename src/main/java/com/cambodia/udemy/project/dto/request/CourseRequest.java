package com.cambodia.udemy.project.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequest {
    private String courseName;
    private Long categoryId;
    private Long idUsers;
}
