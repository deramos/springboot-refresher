package io.kairos.application;

import io.kairos.application.model.Student;
import io.kairos.application.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		/*Student s1 = context.getBean(Student.class);
		s1.setRollNo(2);
		s1.setName("Kamsi");
		s1.setMarks(90);

		Student s2 = context.getBean(Student.class);
		s2.setRollNo(3);
		s2.setMarks(90);
		s2.setName("Nkem");*/
//
//		StudentRepository repo = context.getBean(StudentRepository.class);
//		Optional<Student> s = repo.findById(3);
//		System.out.println(s.orElse(null));
//
//		System.out.println(repo.findByName("Kamsi"));
//		System.out.println(repo.findByMarksGreaterThan(75));
	}

}
