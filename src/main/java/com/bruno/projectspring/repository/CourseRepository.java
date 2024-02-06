package com.bruno.projectspring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.projectspring.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}