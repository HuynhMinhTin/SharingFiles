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

import java.util.List;

import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;
import com.dxc.service.FileService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	FileService fileService;
	
	@GetMapping
	public String Default (ModelMap map) {
		map.addAttribute("message", "This is Get Method using @GetMapping annotation..!");
		return "home";
	}
	
	@GetMapping("/{idUser}")
	public String TestUser (@PathVariable int idUser , ModelMap modelMap) {
		
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
		
		System.out.print(idUser);
		
		modelMap.addAttribute("message", "This is Get Method using @GetMapping annotation..!");
		
		
		return "home";
	}
	
	
	
	@PostMapping("/{idUser}")
	public String UploadFile (@PathVariable int idUser , ModelMap modelMap,HttpServletRequest request , @RequestParam("upload_file_form") MultipartFile fileUpload) throws Exception {
		
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
		
		FileEntity file = new FileEntity();
		UserEntity user = new UserEntity();
		user.setIdUser(idUser);
		
		file.setNameFile(fileUpload.getOriginalFilename());
		
		file.setSizeFile(fileUpload.getSize());
		
		file.setCommentFile("This is a file of User : " +idUser);
		file.setIdUser(user);
		
		file.setDetail(fileUpload.getBytes());
		
		
		boolean check = fileService.UploadFile(file);
		
		if(check){
			List<FileEntity> fileDetail = fileService.GetInfoFile(idUser)	;	
			
			for(FileEntity f : fileDetail){
				System.out.println(f.getNameFile());
			}
		}else{
			modelMap.addAttribute("message", "Wrong!!!!!!!!!!!!!!!!!");
		}
		
		
		//System.out.println(idUser);
		//modelMap.addAttribute("message", "This is Get Method using @POSTMApping annotation..!");
		
		//System.out.println(fileUpload.getOriginalFilename());
		return "home";
}
}
