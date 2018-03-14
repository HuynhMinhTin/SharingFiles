package com.dxc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.dxc.entitty.CategoryEntity;
import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;
import com.dxc.service.CategoryService;
import com.dxc.service.FileService;
import com.dxc.service.SearchService;
import com.dxc.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	FileService fileService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categoryService;
	
	
	@Autowired
	SearchService searchService;
	
	FileEntity file = new FileEntity();
	UserEntity user = new UserEntity();
	
	boolean check= false;
	
	
	public ModelMap GetAllCategory(ModelMap modelMap) {
		if(categoryService.GetCategory() != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}
		return modelMap;
	}
	
	
	public ModelMap GetFirstLetter(HttpSession httpSession , ModelMap modelMap){
		if(httpSession.getAttribute("userName") != null){
			String email = (String) httpSession.getAttribute("userName");
			System.out.println("This is a message from : login page : " + email);
			String firstLetter = email.substring(0, 1);
			modelMap.addAttribute("message",firstLetter.toUpperCase());
			
			//user name
			String[] parts = email.split("@");
			modelMap.addAttribute("emailUser", parts[0]);
		}
		return modelMap;
	}
	
	
	
	
	@GetMapping
	public String Default (ModelMap modelMap) {
		
		modelMap = GetAllCategory(modelMap);
		return "home";
	}
	
	
	@GetMapping("/{idUser}")
	@Transactional
	public String TestUser (@PathVariable int idUser , ModelMap modelMap ,HttpSession httpSession) {

		
		
		modelMap = GetFirstLetter(httpSession, modelMap);
		
		modelMap = GetAllCategory(modelMap);
		
			List<FileEntity> fileDetail = fileService.GetInfoFile(idUser)	;	
			modelMap.addAttribute("listFiles", fileDetail);
			
		return "home";
	}

	@PostMapping("/{idUser}")
	public String UploadFile (@PathVariable int idUser , ModelMap modelMap, @RequestParam("upload_file_form") MultipartFile fileUpload  , 
			HttpSession httpSession) throws Exception {
		
		
		int idLevel = fileService.GetIdUser(idUser);
		long totalSize = 0;
		
		
		modelMap = GetFirstLetter(httpSession, modelMap);
		
		modelMap = GetAllCategory(modelMap);
		
		
		//Level User is  Bronze
		if(idLevel==1){
			// >5MB
			if(fileUpload.getSize() > 5242880){
				modelMap.addAttribute("messageFile", "Level wrong ! You have to upaload file < 5MB");
			}
			else{			
				totalSize = userService.GetTotalSize(idUser) + fileUpload.getSize();
				
				SaveFile(idUser, fileUpload, modelMap,totalSize);
				
				boolean checkUserUpadate = userService.UpdateUser(idUser, totalSize);
				
				if(checkUserUpadate){
					System.out.println("Update auto success");
				}
				else{
					System.out.println("Update auto fails");
				}
				
				
			}
		}
		//Level User is Silver
		else if(idLevel==2){
			// >10MB
			if(fileUpload.getSize() > 10485760){
				modelMap.addAttribute("messageFile", "Level wrong ! You have to upaload file < 10MB");
			}
			else{	
				totalSize = userService.GetTotalSize(idUser) + fileUpload.getSize();
				
				SaveFile(idUser, fileUpload, modelMap,totalSize);
				
				boolean checkUserUpadate = userService.UpdateUser(idUser, totalSize);
				
				if(checkUserUpadate){
					System.out.println("Update auto success");
				}
				else{
					System.out.println("Update auto fails");
				}
			}
		}
		//Level User is Gold 
		else if(idLevel==3){
			// >20MB
			if(fileUpload.getSize() > 20971520){
				modelMap.addAttribute("messageFile", "Level wrong ! You have to upaload file < 20MB");
			}
			else{
				//SaveFile(idUser, fileUpload, modelMap,totalSize);
				
				totalSize = userService.GetTotalSize(idUser) + fileUpload.getSize();
				
				SaveFile(idUser, fileUpload, modelMap,totalSize);
				
				boolean checkUserUpadate = userService.UpdateUser(idUser, totalSize);
				
				if(checkUserUpadate){
					System.out.println("Update auto success");
				}
				else{
					System.out.println("Update auto fails");
				}	
			}
		}
		else{
			modelMap.addAttribute("messageFile", "Level wrong !Nothing to show");
		}
		
		
		//load info => view
		List<FileEntity> fileDetail = fileService.GetInfoFile(idUser)	;	
		modelMap.addAttribute("listFiles", fileDetail);
		
		
		return "home";
}
	void SaveFile(int idUser , MultipartFile fileUpload,ModelMap modelMap ,long totalSizeUser){

	
		
		user.setIdUser(idUser);
//		user.setTotalSize(totalSizeUser);
		
		//save file
		file.setNameFile(fileUpload.getOriginalFilename());
		file.setSizeFile(fileUpload.getSize());
		file.setCommentFile("This is a file of User : " +idUser);
		file.setIdUser(user);
		try {
			file.setDetail(fileUpload.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// save file into database
		
		
		check = fileService.UploadFile(file);
		
	}
	
	
	
	
	
	
}
