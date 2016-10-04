package com.vikas.groundrun.tool.validators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.vikas.groundrun.tool.dto.SignUpForm;
import com.vikas.groundrun.tool.entities.User;
import com.vikas.groundrun.tool.repositories.UserRepository;

@Component
public class SignUpFormValidator extends LocalValidatorFactoryBean {
	
	private UserRepository userRepository;
	
	@Resource
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(SignUpForm.class);
	}

	@Override
	public void validate(Object obj, Errors errors, final Object... validationHints) {
		// TODO Auto-generated method stub
		super.validate(obj, errors, validationHints);
		
		if (!errors.hasErrors()) {
			SignUpForm signUpForm = (SignUpForm) obj;
			
			User user = userRepository.findByEmail(signUpForm.getEmail());
			
			if (user != null)
				errors.rejectValue("email", "emailNotUnique");
		}
		
	}

	
}
