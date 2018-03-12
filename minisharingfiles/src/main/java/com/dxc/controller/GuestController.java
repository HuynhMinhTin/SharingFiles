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
import com.dxc.service.GuestSevice;

@Controller
@RequestMapping("/")
public class GuestController {

	@Autowired
	GuestSevice guestService3;
	FileEntity file = new FileEntity();
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FileService fileService;


	@GetMapping
	public String listguest(ModelMap modelMap) throws Exception {
		List<FileEntity> fileDetail = guestService3.GetAllInfoFile();						
		modelMap.addAttribute("listFiles", fileDetail);	
		
		
		if(categoryService != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}
		//cho ra dnah sách  các file chua  cho loc theo danh muc trả ve listfile
		System.out.println(fileDetail);
		return "guest";
	}
		
	@GetMapping("/cate-{idCategory}")
	public String Default(@PathVariable int idCategory , ModelMap modelMap){
		
		
		if(categoryService != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}
		
	if(fileService.GetFileFromCategory(idCategory) != null ){
		List<FileEntity> listcategory = fileService.GetFileFromCategory(idCategory);
	
		modelMap.addAttribute("listFiles", listcategory);
	}
		
	//System.out.println("GetMapping");
		return "guest";
		
		
	}
//System.out.println(categoryEntities);


}
