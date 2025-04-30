package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.cache.StudentCache;
import com.example.demo.exception.StudentServiceException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentCache cache;
	
	@Autowired
	StudentRepository studentRepo;

	
	@Override
	public void addStudent(Student student) {
		if(student.getId() < 1000)
		{
			throw new StudentServiceException("Provide valid Id", HttpStatus.BAD_REQUEST);
		}
		studentRepo.save(student);
		
		if(studentRepo.existsById(student.getId()))
		{
			throw new StudentServiceException("Student already exists", HttpStatus.CONFLICT);
		}
		
	}

	@Override
	public void addStudents(List<Student> student) {
		studentRepo.saveAll(student);
		
	}

	@Override
	public Student getStudent(int id) {
		return cache.getStudent(id);
	}

	@Override
	public List<Student> getStudents() {
		return cache.getStudents();
	}

	@Override
	public void deleteStudent(int id) {
		studentRepo.deleteById(id);
		
	}

	@Override
	public void deleteStudents() {
		studentRepo.deleteAll();
		
	}
	

}
