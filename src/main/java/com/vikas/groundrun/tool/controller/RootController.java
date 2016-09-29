package com.vikas.groundrun.tool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RootController {
	
	// Can write to response body or can forward a view
	/*@RequestMapping("/")
	public String home() {
		return "home";
	}*/
	
	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("name", "vikas");
		return "signup";
	}

}
