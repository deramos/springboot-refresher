package io.kairos.application.service;

import io.kairos.application.model.Student;
import io.kairos.application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(int studentId) {
        System.out.println("Inside get student by Id");
        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElseGet(Student::new);
    }

    public Student createStudent(Student student) {
        System.out.println("Creating new student");
        return studentRepository.save(student);
    }
}
