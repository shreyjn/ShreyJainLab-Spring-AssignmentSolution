package com.greatlearning.lab6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.lab6.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u from User u where u.username= ?1")
	public User getUserByUserName(String username);
}