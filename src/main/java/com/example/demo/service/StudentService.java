package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.IStudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

//El mapper se hace en la service y esta capa tmb tiene acceder a repository
@Service
public class StudentService implements IStudentService{

    @Autowired
    IStudentRepository studentRepository;

    @Autowired
    ObjectMapper mapper;
    //Void xq creamos y aca siempre usamos el DTO
    //Al mandar un id nuevo un estudiante nuevo, lo crea
    public void createStudent(StudentDTO studentDTO){
        //Student student = new Student();
        //student.setId(student.getId());
        //Arriba tengo una forma y abajo tengo un maper que le digo a StudentDTO convertilo a student
        //al objeto studenDTO convertilo al objeto student
        Student student = mapper.convertValue(studentDTO, Student.class);
        studentRepository.save(student);
    }

    public StudentDTO readStudent(Long id){
        StudentDTO studentDTO = null;
        Optional<Student> student= studentRepository.findById(id);
        if (student.isPresent()){
            studentDTO = mapper.convertValue(student, StudentDTO.class);
        }
        return studentDTO;
    }
    //Si yo le mando un estudiante que existe lo modifica, un id que existe hace un update
    public void updateStudent(StudentDTO studentDTO){
        Student student=mapper.convertValue(studentDTO, Student.class);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Collection<StudentDTO> getAll(){
       List<Student> studentList= studentRepository.findAll();
        Set<StudentDTO> studentsDTO= new HashSet<>();
       for (Student student: studentList){
           studentsDTO.add(mapper.convertValue(student, StudentDTO.class));
       }
       return studentsDTO;
    }

    public Set<StudentDTO> getStudentWithLastNameLike(String lastName){
        Set<Student> studentSet= studentRepository.getStudentByLastNameLike(lastName);
        Set<StudentDTO> studentsDTO= new HashSet<>();
        for (Student student: studentSet){
            studentsDTO.add(mapper.convertValue(student, StudentDTO.class));
        }
        return studentsDTO;
    }


}
