package com.example.demo.controller;

import com.example.demo.model.StudentDTO;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService studentService;
    //esto no devuelve solo lo crea por eso va <?> si quiero puede hacer q me devuelva el estudiante creado
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO studentDTO){
        studentService.createStudent(studentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable long id){
        return studentService.readStudent(id);
    }

    //vamos a responder ok si lo modifico o no
    @PutMapping()
    public ResponseEntity<?> upadateStudent(@RequestBody StudentDTO studentDTO){
        studentService.updateStudent(studentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado!");
    }

    @GetMapping("/list")
    public Collection<StudentDTO> listStudents(){
        return  studentService.getAll();
    }

    @GetMapping("/listlastname")
    public Set<StudentDTO> listStudents(@RequestParam String lastname){
        return studentService.getStudentWithLastNameLike(lastname);
    }
}
