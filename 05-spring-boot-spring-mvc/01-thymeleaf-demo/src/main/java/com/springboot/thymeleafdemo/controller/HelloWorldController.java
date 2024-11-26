package com.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
