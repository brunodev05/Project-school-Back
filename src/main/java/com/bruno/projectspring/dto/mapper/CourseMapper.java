package com.bruno.projectspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.bruno.projectspring.dto.CourseDTO;
import com.bruno.projectspring.enums.Category;
import com.bruno.projectspring.enums.Status;
import com.bruno.projectspring.model.Course;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course){
        if (course == null) {
            return null;
            
        }
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), course.getStatus().getValue());
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
            case "Matemática" -> Category.MATEMATICA;
            case "Português" -> Category.PORTUGUÊS;
            case "Biologia" -> Category.BIOLOGIA;
            case "Química" -> Category.QUÍMICA;
            case "Física" -> Category.FÍSICA;
            case "História" -> Category.HISTÓRIA;
            case "Geografia" -> Category.GEOGRAFIA;
            case "Artes" -> Category.ARTES;
            default -> throw new IllegalArgumentException("Categoria inválida: " + value);
        };
    }
    
    
}
