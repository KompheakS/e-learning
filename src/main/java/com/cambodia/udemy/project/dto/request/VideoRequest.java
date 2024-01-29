package com.cambodia.udemy.project.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoRequest {
    private String description;
    private String videoLink;
    private Long userId;
    private Long courseId;
}
