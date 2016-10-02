package com.vikas.groundrun.tool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.groundrun.tool.dto.SignUpForm;
import com.vikas.groundrun.tool.entities.User;
import com.vikas.groundrun.tool.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public void signUp(SignUpForm signupForm) {
		User user = new User();
		user.setEmail(signupForm.getEmail());
		user.setPassword(signupForm.getPassword());
		user.setName(signupForm.getName());
		userRepository.save(user);
	}

}
