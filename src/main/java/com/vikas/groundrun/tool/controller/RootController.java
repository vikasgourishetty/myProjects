package com.vikas.groundrun.tool.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.groundrun.tool.dto.SignUpForm;
import com.vikas.groundrun.tool.services.UserService;

@Controller
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	private UserService userService;
	
	@Autowired
	public RootController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute(new SignUpForm());
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@ModelAttribute("signUpForm") @Valid SignUpForm signUpForm,
			BindingResult result){
		
		if (result.hasErrors())
			return "signup";
		
		userService.signUp(signUpForm);
		
		//logger.info(signUpForm.toString());
		return "redirect:/";
	}
}
