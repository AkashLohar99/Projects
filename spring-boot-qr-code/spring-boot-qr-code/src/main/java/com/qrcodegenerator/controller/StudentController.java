package com.qrcodegenerator.controller;

import com.google.zxing.WriterException;
import com.qrcodegenerator.entity.Student;
import com.qrcodegenerator.service.StudentService;
import com.qrcodegenerator.util.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private  StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getStudent() throws IOException, WriterException {
        List<Student> students = studentService.getStudents();
        if(students.size()!=0){
            for (Student student: students){
                QRCodeGenerator.generateQRCode(student);
            }
        }
        return ResponseEntity.ok(studentService.getStudents());

    }
    @PostMapping
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id)
    {
        return studentService.findById(id);

    }


}
