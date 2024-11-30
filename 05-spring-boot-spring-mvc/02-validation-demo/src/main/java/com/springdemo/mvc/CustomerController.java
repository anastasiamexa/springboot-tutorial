package com.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class CustomerController {

  // add an initBinder ... to convert trim input strings
  // remove leading and trailing whitespace
  // resolve issue for our validation
  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }

  @GetMapping("/")
  public String showForm(Model model) {
    model.addAttribute("customer", new Customer());
    return "customer-form";
  }

  @PostMapping("/processForm")
  public String processForm(
      @Valid @ModelAttribute("customer") Customer customer,
      BindingResult bindingResult) {
    System.out.println("Last name: |" + customer.getLastName() + "|");    
    if (bindingResult.hasErrors()) {
      return "customer-form";
    } else {
      return "customer-confirmation";
    }
  }
}
