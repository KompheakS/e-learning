package com.cambodia.udemy.project.service;

import com.cambodia.udemy.project.dto.request.VideoRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;

public interface VideoServices {
    ApiResponse<?> uploadVideo(VideoRequest videoRequest);
}
