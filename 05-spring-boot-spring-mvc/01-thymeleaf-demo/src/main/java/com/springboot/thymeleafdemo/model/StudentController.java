package com.springboot.thymeleafdemo.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

  @GetMapping("/showStudentForm")
  public String showForm(Model model) {
    // create a student object
    Student student = new Student();
    // add student object to the model
    model.addAttribute("student", student);
    return "student-form";
  }

  @PostMapping("/processStudentForm")
  public String processForm(@ModelAttribute("student") Student student) {
    // log the input data
    System.out.println("student: " + student.getFirstName() + " " + student.getLastName());
    return "student-confirmation";
  }
}