package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.dto.request.VideoRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.dto.response.VideoResponse;
import com.cambodia.udemy.project.entity.Courses;
import com.cambodia.udemy.project.entity.Users;
import com.cambodia.udemy.project.entity.Video;
import com.cambodia.udemy.project.exception.CustomBadRequestException;
import com.cambodia.udemy.project.mapper.VideoMapper;
import com.cambodia.udemy.project.mapper.manual.VideoMapperImp;
import com.cambodia.udemy.project.repository.CourseRepository;
import com.cambodia.udemy.project.repository.UserRepository;
import com.cambodia.udemy.project.repository.VideoRepository;
import com.cambodia.udemy.project.service.VideoServices;
import com.cambodia.udemy.project.utils.MessageResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class VideoServicesImp implements VideoServices {

    private final VideoRepository videoRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final VideoMapper videoMapping = Mappers.getMapper(VideoMapper.class);

    @Override
    public ApiResponse<?> uploadVideo(VideoRequest videoRequest) {
        Video video = videoMapping.mapToVideo(videoRequest);
        video.setDateCreated(new Timestamp(System.currentTimeMillis()));
        video.setUserCreated(new Timestamp(System.currentTimeMillis()));
        Optional<Users> userRetrieve = userRepository.findById(videoRequest.getUserId());
        Optional<Courses> courseRetrieve = courseRepository.findById(videoRequest.getCourseId());

        if (userRetrieve.isEmpty()){
            log.info("invalid user Id");
            throw new CustomBadRequestException("cannot upload this video!");
        }
        if (courseRetrieve.isEmpty()){
            log.info("invalid course id!");
            throw new CustomBadRequestException("cannot upload this video!");
        }

        video.setCourses(courseRetrieve.get());
        video.setUsers(userRetrieve.get());
        VideoResponse response = VideoMapperImp.mapToVideoResponse(video);
        try {
            videoRepository.save(video);
        }catch (Exception exception){
            log.info("fail to upload this video!");
            throw new CustomBadRequestException("Cannot Upload This video based the user id and Category!");
        }
        return new ApiResponse<>(HttpStatus.CREATED.value(), MessageResponse.MESSAGE_SUCCESS, response);
    }
}
