package com.cambodia.udemy.project.repository;

import com.cambodia.udemy.project.entity.Courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {
    Optional<Courses> findByCourseName(String courseName);
}
