package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.entitty.CategoryEntity;
import com.dxc.entitty.FileEntity;
import com.dxc.service.CategoryService;
import com.dxc.service.FileService;


@Controller

public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FileService fileService;
	
	@RequestMapping("/home/{idUser}/{idCategory}")
	@GetMapping
	public String Default(@PathVariable int idUser , @PathVariable int idCategory , ModelMap modelMap){
		
		if(categoryService != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}
		if(fileService.GetFileFromCategoryForUser(idCategory, idUser) != null ){
			List<FileEntity> listFile = fileService.GetFileFromCategoryForUser(idCategory, idUser);
		
			modelMap.addAttribute("listFiles", listFile);
			System.out.println("test");
		}
		
		return "home";
	}
	//cate-{id}
}
