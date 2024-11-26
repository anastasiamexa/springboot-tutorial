package com.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
  // method to show the initial HTML form
  @RequestMapping("/showForm")
  public String showForm() {
    return "helloworld-form";
  }
  
  @GetMapping("/processForm")
  // method to process the HTML form
  public String processForm() {
    return "helloworld";
  }

  // method to read form data and add data to the model
  @GetMapping("/processForm2")
  public String letsShoutDude(HttpServletRequest request, Model model) {
    // read the request parameter from the HTML form
    String name = request.getParameter("studentName");
    // convert the data to all caps
    name = name.toUpperCase();
    // create the message
    String result = "Yo! " + name;
    // add message to the model
    model.addAttribute("message", result);
    
    return "helloworld";
  }
}
