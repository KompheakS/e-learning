package com.cambodia.udemy.project.controller;

import com.cambodia.udemy.project.dto.request.VideoRequest;
import com.cambodia.udemy.project.service.VideoServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/video")
public class VideoController {

    private final VideoServices videoServices;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadNewVideo(@RequestBody VideoRequest videoRequest){
        return new ResponseEntity<>(videoServices.uploadVideo(videoRequest), HttpStatus.CREATED);
    }
}
