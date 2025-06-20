package com.example.springbootweb.controller;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
 
@RestController
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/welcome")
	public String meth1() {
		return "<h1> Welcome to Spring Boot Application</h1>";
	}
 
	@GetMapping("/first")
	public ModelAndView meth2() {
		return new ModelAndView("index");
	}
}