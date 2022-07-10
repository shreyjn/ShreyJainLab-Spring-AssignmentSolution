package com.greatlearning.lab6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.lab6.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}