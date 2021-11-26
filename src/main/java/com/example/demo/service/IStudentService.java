package com.example.demo.service;

import com.example.demo.model.StudentDTO;

import java.util.Collection;
import java.util.Set;

public interface IStudentService {

    public void createStudent(StudentDTO studentDTO);

    public StudentDTO readStudent(Long in);

    public void updateStudent(StudentDTO studentDTO);

    public void deleteStudent(Long id);

    public Collection<StudentDTO> getAll();

    public Set<StudentDTO> getStudentWithLastNameLike(String lastname);
}
