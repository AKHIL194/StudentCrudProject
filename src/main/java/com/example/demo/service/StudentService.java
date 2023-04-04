package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> allStudents(){
		return studentRepo.findAll();
	}
	
	public void saveStudent(Student student){
		studentRepo.save(student);
	}
	
	public Student getStudentById(long id){
		return studentRepo.findById(id).get();
	}
	
	public void deleteStudentById(long id){
		studentRepo.deleteById(id);
	}

}
