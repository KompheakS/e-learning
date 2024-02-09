package com.cambodia.udemy.project;

import com.cambodia.udemy.project.dto.request.VideoRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.service.VideoServices;
import com.cambodia.udemy.project.utils.MessageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VideoTest {

    @Autowired
    private VideoServices videoServices;

    @Test
    void testUploadVideo(){
        VideoRequest request = new VideoRequest();
        request.setDescription("test");
        request.setVideoLink("https://youtu.be/q4yiO49zoNc?si=ToCjGPfNXYbMeoyJ");
        request.setCourseId(7L);
        request.setUserId(6L);

        ApiResponse<?> response = videoServices.uploadVideo(request);
        assertEquals(MessageResponse.MESSAGE_SUCCESS, response.getMessage());
    }
}
