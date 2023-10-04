package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // Handler method to handle list student and return mode and view

    @GetMapping("/students")
    public String listStudent(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //create student object to hold student form data
        Student student =new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
      studentService.saveStudent(student);
      return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model){
       model.addAttribute("student",studentService.getStudentById(id));
       return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id ,@ModelAttribute("student") Student student, Model model){

        //get student from database
        Student existigStudent = studentService.getStudentById(id);
        existigStudent.setId(id);
        existigStudent.setFirstName(student.getFirstName());
        existigStudent.setLastName(student.getLastName());
        existigStudent.setEmail(student.getEmail());

        //save updated student object
        studentService.updateStudent(existigStudent);
        return "redirect:/students";
    }
    //Handler method to handel delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
