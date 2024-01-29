package com.cambodia.udemy.project.service;

import com.cambodia.udemy.project.dto.request.VideoRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.entity.Video;

public interface VideoServices {
    void testCreateVideo(Video video);

    ApiResponse<String> createVideo(VideoRequest videoRequest);
}
