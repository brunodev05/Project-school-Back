package com.bruno.projectspring.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bruno.projectspring.dto.CourseDTO;
import com.bruno.projectspring.dto.LessonDTO;
import com.bruno.projectspring.enums.Category;
import com.bruno.projectspring.enums.Status;
import com.bruno.projectspring.model.Course;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course){
        if (course == null) {
            return null;
            
        }
        List<LessonDTO> lessons = course.getLessons()
        .stream()
        .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), lesson.getYoutubeUrl()))
        .collect(Collectors.toList());
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(),
        lessons);
    }
        
        
    public Course toEntity(CourseDTO courseDTO){
        if (courseDTO == null) {
            return null; }

        Course course = new Course();
       if(courseDTO.id() != null) {
        course.setId(courseDTO.id());
       }
       course.setName(courseDTO.name());
       course.setCategory(convertCategoryValue(courseDTO.category()));
       course.setStatus(Status.ACTIVE);
        return course;
    }

    public Category convertCategoryValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Redes" -> Category.REDES;
            case "Front-end" -> Category.FRONT_END;
            case "Back-end" -> Category.BACK_END;
           
            default -> throw new IllegalArgumentException("Categoria inválida: " + value);
        };
    }
    
    
}
