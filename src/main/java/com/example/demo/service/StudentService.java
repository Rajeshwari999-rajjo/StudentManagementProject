package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	
	public void addStudent(Student student);
	
	public void addStudents(List<Student> student);
	
	public Student getStudent(int id);
	
	public List<Student> getStudents();
	
	public void deleteStudent(int id);
	
	public void deleteStudents();
}
