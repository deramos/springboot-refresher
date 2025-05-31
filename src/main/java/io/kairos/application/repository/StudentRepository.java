package io.kairos.application.repository;


import io.kairos.application.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student) {
        System.out.println("Student Saved");
    }
}
