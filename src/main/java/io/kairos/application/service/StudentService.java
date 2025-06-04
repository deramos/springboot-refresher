package io.kairos.application.service;

import io.kairos.application.model.Student;
import io.kairos.application.repository.OldStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private OldStudentRepository studentRepository;

    public OldStudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Autowired
    public void setStudentRepository(OldStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
