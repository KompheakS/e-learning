package com.cambodia.udemy.project.controller;

import com.cambodia.udemy.project.entity.Video;
import com.cambodia.udemy.project.service.VideoServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class VideoController {
    private final VideoServices videoServices;

    @PostMapping("/video/create")
    public ResponseEntity<?> testAddVideo(@RequestBody Video video){
        videoServices.testCreateVideo(video);
        return ResponseEntity.ok("success create video");
    }
}
