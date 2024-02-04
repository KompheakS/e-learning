package com.cambodia.udemy.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoResponse {

    private String courseName;
    private String description;
    private String videoLink;
    private Timestamp dateCreated;
    private Timestamp dateModified;
    private Timestamp userCreated;
    private Timestamp userModified;

}
