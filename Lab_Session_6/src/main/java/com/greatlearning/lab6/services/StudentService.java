package com.greatlearning.lab6.services;

import java.util.List;

import com.greatlearning.lab6.entity.Student;

public interface StudentService {
	public List<Student> getAllStudents();

	public void addStudent(Student s);

	public Student findById(Integer id);

	public void delete(Integer id);
}
