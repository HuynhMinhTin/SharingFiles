package com.dxc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;
import java.util.List;

import com.dxc.entitty.CategoryEntity;
import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;
import com.dxc.service.CategoryService;
import com.dxc.service.FileService;
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
	
	FileEntity file = new FileEntity();
	UserEntity user = new UserEntity();
	
	boolean check= false;
	
	@GetMapping
	public String Default (ModelMap modelMap) {
		if(categoryService != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}
		return "home";
	}
	
	
	@GetMapping("/{idUser}")
	public String TestUser (@PathVariable int idUser , ModelMap modelMap) {
		
			if(categoryService != null){
				List<CategoryEntity> categoryEntities = categoryService.GetCategory();
				modelMap.addAttribute("category", categoryEntities);
			}
		
			List<FileEntity> fileDetail = fileService.GetInfoFile(idUser)	;	
			modelMap.addAttribute("listFiles", fileDetail);
			
			
			
			
	
		//modelMap.addAttribute("message", "This is Get Method using @GetMapping annotation..!");	
		return "home";
	}

	@PostMapping("/{idUser}")
	public String UploadFile (@PathVariable int idUser , ModelMap modelMap, @RequestParam("upload_file_form") MultipartFile fileUpload) throws Exception {
		
		
		int idLevel = fileService.GetIdUser(idUser);
		long totalSize = 0;
		
		if(categoryService != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}
	
		
		//System.out.println(idLevel);
		//Level User is  Bronze
		if(idLevel==1){
			// >5MB
			if(fileUpload.getSize() > 5242880){
				modelMap.addAttribute("message", "Level wrong ! You have to upaload file < 5MB");
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
				modelMap.addAttribute("message", "Level wrong ! You have to upaload file < 10MB");
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
				modelMap.addAttribute("message", "Level wrong ! You have to upaload file < 20MB");
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
			modelMap.addAttribute("message", "Level wrong !Nothing to show");
		}
		
		
		//load info => view
		List<FileEntity> fileDetail = fileService.GetInfoFile(idUser)	;	
		modelMap.addAttribute("listFiles", fileDetail);
		
		
		//System.out.println(idUser);
		//modelMap.addAttribute("message", "This is Get Method using @POSTMApping annotation..!");
		
		//System.out.println(fileUpload.getOriginalFilename());
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
