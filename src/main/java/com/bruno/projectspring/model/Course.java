package com.bruno.projectspring.model;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;

import com.bruno.projectspring.enums.Category;
import com.bruno.projectspring.enums.Status;
import com.bruno.projectspring.enums.convertes.CategoryConverter;
import com.bruno.projectspring.enums.convertes.StatusConverter;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
@SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?")
@org.hibernate.annotations.Where(clause = "status = 'Ativo'")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;
    
    @NotBlank
    @NotNull
    @org.hibernate.validator.constraints.Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;


    @NotNull
   // @org.hibernate.validator.constraints.Length(max = 10)
   // @Pattern(regexp = "Matemática|Português|Biologia|Química|Física|História|Geografia|Artes")
    @Column(length  = 10,nullable = false)
    @Convert(converter = CategoryConverter.class)
    private Category category;


    @NotNull
 @Column(length = 10, nullable = false)
 @Convert(converter = StatusConverter.class)

 private Status status = Status.ACTIVE;

@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "course")
private List<Lesson> lessons = new ArrayList <>();
  
    
}
