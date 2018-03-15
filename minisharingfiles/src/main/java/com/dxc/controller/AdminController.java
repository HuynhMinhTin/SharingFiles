package com.dxc.controller;

import java.util.List;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.entitty.LevelUserEntity;
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

	@PostMapping
	public String delete(ModelMap mm, @RequestParam(value = "id") int id) {

		System.out.println("Delete User controller");
		adminservice.DeleteUser(id);
		List<UserEntity> listUser;
		listUser = adminservice.GetAllUser();
		mm.addAttribute("listUser", listUser);
		return "admin";
	}

	@PostMapping(value = "/{id}")
	public String update(ModelMap mm,@PathVariable(value = "id") int idUser
			,@RequestParam String nameUser ,@RequestParam String emailUser  , @RequestParam int levelUser) {
		
		
		UserEntity userEntity = adminservice.LoadUser(idUser);
		
		userEntity.setNameUser(nameUser);
		userEntity.setEmailUser(emailUser);
		LevelUserEntity levelUserEntity = adminservice.GetLeve(levelUser);
		
		userEntity.setIdLevel(levelUserEntity);
		
		adminservice.UpdateUser(userEntity);
		
		
		return "redirect:/admin";
	}

	@GetMapping("/{id}")
	public String getUploadPage(ModelMap mm,  @PathVariable(value = "id") int id) {
		UserEntity user;
		user = adminservice.LoadUser(id);
		mm.addAttribute("user", user);

		return "update";
	}

}
