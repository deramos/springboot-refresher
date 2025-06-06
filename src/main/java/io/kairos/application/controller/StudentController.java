package io.kairos.application.controller;

import io.kairos.application.model.Student;
import io.kairos.application.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentId) {
        Student student = studentService.getStudent(studentId);
        if (student.getRollNo() > 0)
            return ResponseEntity.ok(student);
        else
            return ResponseEntity.notFound().build();

    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentService.createStudent(student);
        if (newStudent.getRollNo() > 0) {
            return ResponseEntity.ok(newStudent);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
