package com.cambodia.udemy.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "TB_VIDEO")
@Data
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "V_ID")
    private Long id;
    @Column(name = "v_description")
    private String description;
    @Column(name = "v_video_link")
    private String videoLink;
    /* This feature need change this field*/
/*    @Lob
    @Column(name = "V_IMAGE")
    private byte[] imageCover;*/
    @Column(name = "V_DATE_CREATED")
    private Timestamp dateCreated;
    @Column(name = "V_DATE_MODIFIED")
    private Timestamp dateModified;
    @Column(name = "V_USER_CREATED")
    private Timestamp userCreated;
    @Column(name = "V_USER_MODIFIED")
    private Timestamp userModified;

    @ManyToOne
    @JoinColumn(name = "V_USER_ID")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "V_COURSE_ID")
    private Courses courses;
}
