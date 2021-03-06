package com.vikas.groundrun.tool.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vikas.groundrun.tool.dto.SignUpForm;
import com.vikas.groundrun.tool.services.UserService;
import com.vikas.groundrun.tool.util.MyUtil;
import com.vikas.groundrun.tool.validators.SignUpFormValidator;

@Controller
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	private UserService userService;
	private SignUpFormValidator signUpFormValidator;
	
	@Autowired
	public RootController(UserService userService, SignUpFormValidator signUpFormValidator) {
		this.userService = userService;
		this.signUpFormValidator = signUpFormValidator;
	}
	
	@InitBinder("signUpForm")
	protected void initSignUpBinder(WebDataBinder binder) {
		binder.setValidator(signUpFormValidator);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute(new SignUpForm());
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@ModelAttribute("signUpForm") @Valid SignUpForm signUpForm,
			BindingResult result, RedirectAttributes redirectAttributes){
		
		if (result.hasErrors())
			return "signup";
		
		userService.signUp(signUpForm);
		
		MyUtil.flash(redirectAttributes, "success", "signupSuccess");
		
		//logger.info(signUpForm.toString());
		return "redirect:/";
	}
}
