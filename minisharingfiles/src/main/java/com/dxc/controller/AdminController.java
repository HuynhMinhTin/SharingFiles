package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.entitty.UserEntity;
import com.dxc.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminservice;
	UserEntity user = new UserEntity();


	@GetMapping
	public String show(ModelMap mm) {
		List<UserEntity> listUser;
		listUser = adminservice.GetAllUser();
		for (UserEntity s : listUser) {
			System.out.println(s.getEmailUser());
		}
		mm.addAttribute("listUser", listUser);
		return "admin";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(ModelMap mm, @PathVariable(value = "id") int id) {
		System.out.println("Delete User controller");

		adminservice.DeleteUser(id);
		
		return "admin";
	}

}
