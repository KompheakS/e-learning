package com.cambodia.udemy.project.mapper.manual;

import com.cambodia.udemy.project.dto.response.VideoResponse;
import com.cambodia.udemy.project.entity.Video;

public class VideoMapperImp {

    public static VideoResponse mapToVideoResponse(Video video){
        VideoResponse videoResponse = new VideoResponse();

        videoResponse.setCourseName(video.getCourses().getCourseName());
        videoResponse.setDescription(video.getDescription());
        videoResponse.setVideoLink(video.getVideoLink());
        videoResponse.setDateCreated(video.getDateCreated());
        videoResponse.setDateModified(video.getDateModified());
        videoResponse.setUserCreated(video.getUserCreated());
        videoResponse.setUserModified(video.getUserModified());

        return videoResponse;
    }
}
