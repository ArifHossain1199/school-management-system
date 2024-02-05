package com.arif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arif.model.Student;
import com.arif.service.StudentService;

@RestController
@RequestMapping("/studs")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public String greeting() {
		return "Welcome to School Management System";
	}
	@PostMapping("/saveStud")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@GetMapping("/{className}")
	public List<Student> findStudentsByClass(@PathVariable String className) {
		return studentService.findByCurrClass(className);
	}

}
