package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.entity.Video;
import com.cambodia.udemy.project.repository.VideoRepository;
import com.cambodia.udemy.project.service.VideoServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VideoServicesImp implements VideoServices {
    private final VideoRepository videoRepository;

    @Override
    public void testCreateVideo(Video video){
        videoRepository.save(video);
    }
}
