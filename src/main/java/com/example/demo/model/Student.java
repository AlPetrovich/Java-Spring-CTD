package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity                 //1-Es una entidad
@Table(name="Students")//2-Tabla con la que quiero que machee
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;
    //Un estudiante tiene muchos cursos con hibernate se utilizan set
    @OneToMany(mappedBy = "student")
    @JsonIgnore  //sino entra en un ciclo infinito
    private Set<Course> courses;
}
