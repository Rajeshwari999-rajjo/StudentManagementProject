package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentservice;

	@PostMapping("Student")
	public String addStudent(@RequestBody Student student) {
		studentservice.addStudent(student);
		return "Student added sucessfully!...";
	}

	@PostMapping("students")
	public String addStudents(List<Student> students) {
		studentservice.addStudents(students);
		return "Students added sucessfully!...";
	}

	@GetMapping("Student/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		return studentservice.getStudent(id);
	}

	@GetMapping("Students")
	public List<Student> getStudents() {
		return studentservice.getStudents();
	}

	@DeleteMapping("Student/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		studentservice.deleteStudent(id);
		return "Student deleted sucessfully!...";
	}

	@DeleteMapping("Students")
	public String deleteStudents() {
		studentservice.deleteStudents();
		return "Students deleted sucessfully!...";
	}
}
