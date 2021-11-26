package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Subjects")
@Setter @Getter
public class Subject {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String leader;

    @OneToMany(mappedBy = "subject")  //le pedimos que en curso mapee con el objeto subject
    @JsonIgnore //sino entra en un ciclo infinito
    private Set<Course> course;
}
