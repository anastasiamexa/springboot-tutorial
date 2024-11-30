package com.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
  // method to show the initial HTML form
  @GetMapping("/showForm")
  public String showForm() {
    return "helloworld-form";
  }
  
  @RequestMapping("/processForm")
  // method to process the HTML form
  public String processForm() {
    return "helloworld";
  }

  // method to read form data and add data to the model
  @RequestMapping("/processForm2")
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

  // method to read form data and add data to the model via @RequestParam
  @PostMapping("/processForm3")
  public String processForm3(@RequestParam("studentName") String name, Model model) {
    // convert the data to all caps
    name = name.toUpperCase();
    // create the message
    String result = "Hey my friend! " + name;
    // add message to the model
    model.addAttribute("message", result);
    
    return "helloworld";
  }
}
