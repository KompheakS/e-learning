package com.cambodia.udemy.project.mapper;

import com.cambodia.udemy.project.dto.request.VideoRequest;
import com.cambodia.udemy.project.entity.Video;
import org.mapstruct.Mapper;

@Mapper
public interface VideoMapper {
    Video mapToVideo(VideoRequest videoRequest);
}
