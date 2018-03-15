package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.service.AdminService;
import com.dxc.entitty.UserEntity;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminservice;
	UserEntity user = new UserEntity();
	@GetMapping
	public String update(ModelMap mm) {
		List<UserEntity> listUser;
		listUser = adminservice.GetAllUser();
		for (UserEntity s : listUser) {
			System.out.println(s.getEmailUser());
		}
		mm.addAttribute("listUser", listUser);
		return "admin";
	}
	
	@PostMapping
	public String delete(ModelMap mm, @RequestParam(value = "id") int id) {
		
		System.out.println("Delete User controller");
		adminservice.DeleteUser(id);
		List<UserEntity> listUser;
		listUser = adminservice.GetAllUser();
		mm.addAttribute("listUser", listUser);
		return "admin";
	}
}