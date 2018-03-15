package com.dxc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxc.entitty.CategoryEntity;
import com.dxc.entitty.FileEntity;
import com.dxc.service.CategoryService;
import com.dxc.service.FileService;
import com.dxc.service.GuestSevice;
import com.dxc.service.SearchService;

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
	
	@Autowired
	SearchService searchService;

	
	@ResponseBody
	@GetMapping("/indexData")
	public String indexData() {
		try {
			searchService.indexBooks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Indexed at " + new Date().toGMTString();
	}

	

	@GetMapping
	public String listguest(ModelMap modelMap) throws Exception {
		List<FileEntity> fileDetail = guestService3.GetAllInfoFile();						
		modelMap.addAttribute("listFiles", fileDetail);	
		
		
		if(categoryService != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}
		
		//System.out.println(fileDetail);
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
		return "guest";

	}
	
	
	@PostMapping
	public String SearchFile(@RequestParam String filename_search , ModelMap modelMap , @RequestParam String selector ){
		
	/*	String selectedStr = request.getParameter("selector_id");
		System.out.println(selectedStr);*/
		
		List<FileEntity> listFiles = null ;
		
		System.out.println(selector);
		
		if (selector.equals("category")){
			
			
			
		}else if (selector.equals("uploader")){
		
		}else if(selector.equals("size")){
			
		}else{
			listFiles = searchService.SearchFileHQL(filename_search);	
		}
							
		modelMap.addAttribute("listFiles", listFiles);	
		
		
		if(categoryService.GetCategory() != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}

		
		return "guest";
		
	}
	

}
