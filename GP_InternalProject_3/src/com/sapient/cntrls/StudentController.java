package com.sapient.cntrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/")
	public String init() {

		return "index";
	}

	@RequestMapping("/add")
	public String addObject() {
		return "add";
	}

	@ModelAttribute("department")
	public String[] types() {
		return new String[] { "IT", "CSE", "ECE", "EEE" };
	}
}
