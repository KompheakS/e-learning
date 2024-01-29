package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.dto.request.VideoRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.entity.Category;
import com.cambodia.udemy.project.entity.Users;
import com.cambodia.udemy.project.entity.Video;
import com.cambodia.udemy.project.mapper.VideoMapping;
import com.cambodia.udemy.project.repository.CategoryRepository;
import com.cambodia.udemy.project.repository.CourseRepository;
import com.cambodia.udemy.project.repository.UserRepository;
import com.cambodia.udemy.project.repository.VideoRepository;
import com.cambodia.udemy.project.service.VideoServices;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;


/*
* Note:
* - change video's request because it depends on the course table.
* - and then implement on the service impl and controller.
* */

@Service
@AllArgsConstructor
public class VideoServicesImp implements VideoServices {
    private final VideoRepository videoRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final VideoMapping videoMapping = Mappers.getMapper(VideoMapping.class);

    @Override
    public void testCreateVideo(Video video){
        videoRepository.save(video);
    }

    @Override
    public ApiResponse<String> createVideo(VideoRequest videoRequest) {
        Video video = videoMapping.mapToVideo(videoRequest);
        video.setDateCreated(new Timestamp(System.currentTimeMillis()));
        video.setUserCreated(new Timestamp(System.currentTimeMillis()));
        Optional<Users> user = userRepository.findById(videoRequest.getUserId());

        return null;
    }
}
