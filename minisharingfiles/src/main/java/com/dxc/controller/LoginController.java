package com.dxc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.dxc.service.UserService;

@Controller
@RequestMapping("/login")
//@SessionAttributes("idUserLogin")
public class LoginController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String Default(){
		return "login";
	}
	
	@PostMapping
	public String Login (@RequestParam String password_login_form , @RequestParam String email_login_form , ModelMap modelMap, HttpSession httpSession) {
		
		boolean checkLogin = userService.CheckLogin(email_login_form, password_login_form);	
		
		if(checkLogin) {
			
			int idUser = userService.getIDUser();
			httpSession.setAttribute("userName", email_login_form);
			//modelMap.addAttribute("userName", email_login_form);
			//admin
			if(idUser == 1) {
				return "redirect:admin";
			}
			//user
			else {
				return "redirect:home/"+idUser;
			}	
		}else {
			modelMap.addAttribute("checkUserLogin", "This email and password combination is incorrect.");
			return "login";
		}
	}
	
	
	
}
