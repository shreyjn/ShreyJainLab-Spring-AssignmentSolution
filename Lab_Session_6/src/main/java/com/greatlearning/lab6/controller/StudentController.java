package com.greatlearning.lab6.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.lab6.entity.Student;
import com.greatlearning.lab6.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@RequestMapping("/")
	public String home(Model m) {
		List<Student> student_list = service.getAllStudents();
		m.addAttribute("student_list", student_list);
		return "index";
	}

	@GetMapping("/addStudent")
	public String addStudentForm() {
		return "addStudent";
	}

	@PostMapping("/submit")
	public String StudentRegister(@ModelAttribute Student s, HttpSession session) {
		service.addStudent(s);
		session.setAttribute("msg", "Student Added Successfully!!!");
		return "redirect:/";
	}

	@GetMapping("/update/{id}")
	public String edit(@PathVariable int id, Model m) {
		Student s = service.findById(id);
		m.addAttribute("student", s);

		return "update";
	}

	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student s, HttpSession session) {
		service.addStudent(s);
		session.setAttribute("msg", "Data Updated Successfully...");
		return "redirect:/";

	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id, HttpSession session) {
		service.delete(id);
		session.setAttribute("msg", "Student Deleted Successfully...");
		return "redirect:/";
	}
}
