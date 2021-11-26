package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Courses")
@Setter @Getter
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private int nota;
    //Muchos curso pertenece a un estudiante
    //es una relacion de muchos a muchos por ende se forma una tabla intermedia
    //entonces hay que decir que este atributo joinea" con el atributo student_id y que no puede ser null
    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
}
