package com.greatlearning.lab6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.lab6.entity.Student;
import com.greatlearning.lab6.repositories.StudentRepository;

@Service
public class StudentServiceImpln implements StudentService {

	@Autowired
	private StudentRepository stu_Repo;

	@Override
	public List<Student> getAllStudents() {
		return stu_Repo.findAll();
	}

	@Override
	public void addStudent(Student student) {
		stu_Repo.save(student);
	}

	@Override
	public Student findById(Integer id) {
		Optional<Student> student = stu_Repo.findById(id);
		if (student.isPresent()) {
			return student.get();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		stu_Repo.deleteById(id);
	}

}
