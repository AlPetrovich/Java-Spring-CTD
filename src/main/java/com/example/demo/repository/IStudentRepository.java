package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
//lo que va en param lo llamo en la query
@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Query("FROM Student s WHERE s.lastname LIKE %:lastnamexx%")
    Set<Student> getStudentByLastNameLike(@Param("lastnamexx") String lastname);

}
