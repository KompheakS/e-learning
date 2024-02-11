package com.cambodia.udemy.project.repository;

import com.cambodia.udemy.project.entity.Video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByCoursesId(int courses_id);
}
