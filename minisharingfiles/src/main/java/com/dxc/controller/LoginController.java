package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String Default(){
		return "login";
	}
	
	@PostMapping
	public String Login (@RequestParam String password_login_form , @RequestParam String email_login_form , ModelMap map) {
		
		boolean checkLogin = userService.CheckLogin(email_login_form, password_login_form);	
		
		if(checkLogin) {
			//map.addAttribute("checkUserLogin", "OK");
			return "redirect:home";
			
		}else {
			map.addAttribute("checkUserLogin", "This email and password combination is incorrect.");
			return "login";
		}
	}
	
	
	
}
