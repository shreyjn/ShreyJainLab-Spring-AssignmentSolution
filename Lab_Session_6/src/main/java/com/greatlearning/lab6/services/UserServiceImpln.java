package com.greatlearning.lab6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.lab6.entity.User;
import com.greatlearning.lab6.repositories.UserRepository;
import com.greatlearning.lab6.security.StudentUserDetails;

public class UserServiceImpln implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepo.getUserByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " not found!!!");
		}

		UserDetails studentUserDetails = new StudentUserDetails(user);
		return studentUserDetails;
	}

}
