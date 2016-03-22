package com.sapient.cntrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.daos.StudentDAO;
import com.sapient.entity.Student;

@Controller
public class StudentController {

	@Autowired
	StudentDAO studDAO;

	@Autowired
	private ModelAndView mdl;

	@Autowired
	Student studObj;

	@RequestMapping("/add")
	private ModelAndView initForm() {

		mdl.setViewName("AddDetails");
		mdl.addObject("command", studObj);
		return mdl;

	}

	@RequestMapping("/")
	public String init() {

		return "index";
	}

	@ModelAttribute("department")
	public String[] types() {
		return new String[] { "IT", "CSE", "ECE", "EEE" };
	}

	@RequestMapping(value = "/submitDetails", method = RequestMethod.POST)
	public ModelAndView initForm(@ModelAttribute("data") Student studentObj) {

		mdl.setViewName("AddDetails");
		
		studentObj.setTotalScore(studentObj.calculateTotalScore());
		System.out.println(studentObj);
		studDAO.add(studentObj);

		return mdl;

	}
}
