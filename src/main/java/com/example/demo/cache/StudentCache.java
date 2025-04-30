package com.example.demo.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Component
public class StudentCache {
	
	private Map<Integer, Student> studentMap = new ConcurrentHashMap<>();
	
	@Autowired
	StudentRepository studentRepo;
	
	public void fetchAll()
	{
		List<Student> studentList = studentRepo.findAll();
		for(Student student : studentList)
		{
			studentMap.put(student.getId(), student);
		}
	}
	
	public Student getStudent(int id)
	{
		return studentRepo.findById(id).get();
	}
	
	public List<Student> getStudents()
	{
		return new ArrayList<Student>(studentMap.values());
	}
	
	public void clear()
	{
		studentMap.clear();
	}

}
