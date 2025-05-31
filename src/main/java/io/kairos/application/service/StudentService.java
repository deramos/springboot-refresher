package io.kairos.application.service;

import io.kairos.application.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void addStudent(Student student){
        System.out.println("Student added");
    }
}
