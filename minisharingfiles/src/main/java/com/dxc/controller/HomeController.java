package com.dxc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping
	public String Default () {
		return "home";
	}
	
	
	@GetMapping("/{idUser}")
	public String TestUser (@PathVariable int idUser , ModelMap modelMap, @RequestParam MultipartFile upload_file_form) throws Exception {
		
		/*System.out.println("This is a idUSer :" + idUser);
		
		System.out.println("HttpSession : " + httpSession.getAttribute("idUserLogin"));
		*/
		
	/*	for(CommonsMultipartResolver multi : upload_file) {
			System.out.println(multi.getFileUpload());
			
		}*/
		
		/*for(CommonsMultipartFile multi : btn_upload_file) {
			System.out.println(multi.getOriginalFilename());
		}*/
		
		
		//
		
		System.out.println(upload_file_form.getName());
		
		
		
		
		
		return "home";
	}
	
}
