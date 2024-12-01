package com.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
  // create a mapping for "/hello"
  @RequestMapping("/hello")
  public String sayHello(Model model) {
    model.addAttribute("date", new java.util.Date());
    return "helloworld";
  }
}
