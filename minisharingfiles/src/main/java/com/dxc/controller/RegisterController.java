package com.dxc.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxc.dao.UserDAO;
import com.dxc.entitty.PositionEntity;
import com.dxc.entitty.UserEntity;
import com.dxc.service.UserService;


@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserService userService;
	

	@GetMapping
	public String Default () {
		return "register";
	}
	
	//Registration new user 
	@PostMapping
	public String Registration(@RequestParam String name_form_signup, @RequestParam String email_form_signup ,@RequestParam String password_form_signup ,@RequestParam String confirmpassword ,ModelMap map){
		
		boolean checkEmail = validate(email_form_signup);
		
		PositionEntity positionEntity = new PositionEntity();
		positionEntity.setIdPosition(2);
		
		if(checkEmail){
			if(password_form_signup.equals(confirmpassword)){
				UserEntity user = new UserEntity();
				user.setEmailUser(email_form_signup);
				user.setNameUser(name_form_signup);
				user.setPasswordUser(password_form_signup);
				user.setIdPosition(positionEntity);
				
	
				System.out.println(user);
				
				boolean checkAddUser = userService.AddEmployees(user);
				
				if(checkAddUser) {
					map.addAttribute("checkUserSignUp", "OK");
					System.out.println("OK");
				}else {
					System.out.println("wrong");
					map.addAttribute("checkUserSignUp", "Wrong! This User existed");
					
				}

			}else {
				map.addAttribute("checkUserSignUp", "Password and Confirm password wrong !");
				System.out.println("wrong - check pass");
			}
		}else {
			map.addAttribute("checkUserSignUp", "Fomat email worng!");
			System.out.println("wrong - check mail");
		}
		return "register";
	}
	
	// check format Email 
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();
	}

}
