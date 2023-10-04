package com.studentmanagementsystem;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	@Autowired
    private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
//		Student student = new Student("Akash","Lohar","akashlohar4165@gmail.com");
//		studentRepository.save(student);
//		Student student1 = new Student("Vishal","Lohar","vishal@gmail.com");
//		studentRepository.save(student1);
//		Student student2 = new Student("Shubham","Lohar","Shubham@gmail.com");
//		studentRepository.save(student2);
	}
}
