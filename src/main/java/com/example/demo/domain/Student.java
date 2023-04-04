package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	public Student(Long student_id, String student_name, String course_name, Long course_fees) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.course_name = course_name;
		this.course_fees = course_fees;
	}
	
	public Student() {
		super();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long student_id; 
	@Column
	private String student_name;
	@Column
	private String course_name;
	@Column
	private Long course_fees;
	
	public Long getCourse_fees() {
		return course_fees;
	}
	public void setCourse_fees(Long course_fees) {
		this.course_fees = course_fees;
	}
	
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

}
