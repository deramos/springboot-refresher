package io.kairos.application;

import io.kairos.application.model.Student;
import io.kairos.application.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

		Student student = context.getBean(Student.class);
		student.setRollNo(104);
		student.setName("Chidera");
		student.setMarks(98);

		StudentService studentService = context.getBean(StudentService.class);
		studentService.addStudent(student);

		List<Student> students = studentService.getStudents();
		System.out.println(students);

	}

}
