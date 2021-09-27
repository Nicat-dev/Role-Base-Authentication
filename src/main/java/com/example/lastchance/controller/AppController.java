package com.example.lastchance.controller;

import com.example.lastchance.model.Student;
import com.example.lastchance.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

	@Autowired
	StudentServices service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Student> listStudent = service.listAll();
		model.addAttribute("listStudent",listStudent);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newStudentPage(Model model) {
		Student student=new Student();
		model.addAttribute(student);
		return "new_student";
	}
	
	@RequestMapping(value = "/save", method =RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student ) {
		service.save(student);
		return "redirect:/";
	}
	@RequestMapping("/edit/{sid}")
	public ModelAndView showEditStudentPage(@PathVariable (name="sid") Long sid) {
		ModelAndView mav=new ModelAndView("edit_student");
		Student student=service.get(sid);
		mav.addObject("student",student);
		return mav;
	}
	
	@RequestMapping("/delete/{sid}")
	public String deleteStudentPage(@PathVariable (name="sid") Long sid) {
		service.delete(sid);
		return "redirect:/";
	}
	
}
