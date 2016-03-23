package com.sapient.cntrls;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

	@RequestMapping("/")
	public String init() {

		return "index";
	}

	@RequestMapping("/add")
	private ModelAndView initForm() {

		mdl.setViewName("AddDetails");
		mdl.addObject("command", studObj);
		return mdl;

	}

	@RequestMapping("/view_dept")
	private ModelAndView viewTopThree() {

		mdl.setViewName("ViewDepartment");
		return mdl;

	}

	@ModelAttribute("department")
	public String[] types() {
		return new String[] { "IT", "CSE", "ECE", "EEE" };
	}

	@RequestMapping(value = "/submitDetails", method = RequestMethod.POST)
	public ModelAndView initForm(@ModelAttribute("data") Student studentObj,
			@RequestParam("image") MultipartFile image) {

		File file = null;

		try {
			file = new File(
					"C:\\Users\\gpant\\git\\InternalProject\\GP_InternalProject_3\\WebContent\\Resources\\Images\\"
							+ studentObj.getStudentId() + ".jpg");
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		studentObj.setImagePath(file.getPath());
		studentObj.setTotalScore(studentObj.calculateTotalScore());
		System.out.println(studentObj);
		studDAO.add(studentObj);
		mdl.setViewName("AddDetails");

		return mdl;

	}

	@RequestMapping(value = "/viewTopDetails/{dept}", method = RequestMethod.GET)
	public String getPerformers(@PathVariable("dept") String department, Model mdl) {

		List<Student> list = studDAO.findTopThree(department);
		mdl.addAttribute("student", list);
		return "ViewPerformers";

	}
}
