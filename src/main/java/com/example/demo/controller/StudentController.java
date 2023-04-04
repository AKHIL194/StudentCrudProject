package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String getAllStudents(Model model) {
		List<Student> liststudent = studentService.allStudents();
		model.addAttribute("liststudent", liststudent);
		System.out.println(" Get/ "+liststudent.size());
		return "index";
	}
	
	@RequestMapping("/new")
	public String addStudents(Model model) {
		model.addAttribute("student", new Student());
		System.out.println(" addStudent/ ");
		return "new";
	}
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudents(@ModelAttribute("student") Student std) {
		studentService.saveStudent(std);
		System.out.println(" saveStudent/ ");
		return "redirect:/";
	}
	
	@RequestMapping("/editStudent/{id}")
	public ModelAndView editStudent(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("new");
		Student std = (Student) studentService.getStudentById((long)id);
		mav.addObject("student",std);
		System.out.println(" editStudent/ ");
		return mav;
	}
	
	@RequestMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {
//		Student std = (Student) studentService.getStudentById((long)id);
		System.out.println(" deleteStudent/ ");
		studentService.deleteStudentById(id);
		return "redirect:/";
	}
	
}
