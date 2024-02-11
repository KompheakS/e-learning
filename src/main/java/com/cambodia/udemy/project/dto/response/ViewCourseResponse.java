package com.cambodia.udemy.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewCourseResponse {
    private String courseName;
    private List<VideoResponse> videoResponse;
}
