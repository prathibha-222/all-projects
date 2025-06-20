package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.bean.EmployeeBean;


@Controller
public class AdminController {
@GetMapping("/hello")
public String meth1(Model m,EmployeeBean eb)
{
	eb.setEid(101);
	eb.setEname("Karthik");
	eb.setEsal(56000);
	m.addAttribute("emp", eb);
	m.addAttribute("name", "Sri");
	return "Welcome";
}
}
