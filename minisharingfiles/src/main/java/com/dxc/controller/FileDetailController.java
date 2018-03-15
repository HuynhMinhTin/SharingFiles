package com.dxc.controller;

import java.util.List;








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

import com.dxc.entitty.CategoryEntity;
import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;
import com.dxc.service.CategoryService;
import com.dxc.service.DownloadService;
import com.dxc.service.FileService;


@Controller
@RequestMapping("/home/")
public class FileDetailController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	DownloadService downloadService;
	
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
	
	
	@GetMapping("{idUser}/detail-{idFile}")
	public String Default (ModelMap modelMap , @PathVariable int idFile , HttpServletRequest request  , @PathVariable int idUser , HttpSession httpSession) {
		if(fileService.GetInfoFileDetail(idFile) != null){
			modelMap = GetAllCategory(modelMap);
			FileEntity fileDetail = fileService.GetInfoFileDetail(idFile)	;	
			String[] parts = fileDetail.getNameFile().split("\\.");
			modelMap.addAttribute("kindFile" , parts[1]);
			modelMap.addAttribute("fileDetail", fileDetail);
			
			modelMap = GetFirstLetter(httpSession, modelMap);
			return "download";
			
		}else{
			
			return "download";
		}
		
	}
	
	public ModelMap GetAllCategory(ModelMap modelMap) {
		if(categoryService.GetCategory() != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}
		
		return modelMap;
	}
	
	
	@PostMapping("{idUser}/detail-{idFile}")
	public String UpdateFile (ModelMap modelMap ,@PathVariable int idFile , @RequestParam String  nameUpdate 
			, @RequestParam int categoryUpdate , @RequestParam String commentUpdate , @RequestParam String descriptionUpdate , HttpServletRequest request ,
			@PathVariable int idUser , HttpSession httpSession){
		
		
		modelMap = GetFirstLetter(httpSession, modelMap);
		
		
		if(fileService.GetInfoFileDetail(idFile) != null){
			byte[] getData = downloadService.getDataById(idFile);

			FileEntity fileDetail = fileService.GetInfoFileDetail(idFile);
			//FileEntity fileUpdate = new FileEntity();
			String[] parts = fileDetail.getNameFile().split("\\.");
			
			
			CategoryEntity categoryEntity = categoryService.getCategoryEntity(categoryUpdate);
			
			fileDetail.setIdCategory(categoryEntity);
			fileDetail.setNameFile(nameUpdate +'.'+ parts[1]);
			fileDetail.setCommentFile(commentUpdate);
			fileDetail.setDetail(getData);
			
			fileService.UpdateFile(fileDetail);

		FileEntity fileDetailUpdatedSuccess = fileService.GetInfoFileDetail(idFile)	;	
			
			modelMap.addAttribute("kindFile" , parts[1]);
			modelMap.addAttribute("fileDetail", fileDetailUpdatedSuccess);
			modelMap = GetAllCategory(modelMap);
			
			return "download";
		}else{
			String referer = request.getHeader("Referer");
			return "redirect:"+ referer;
		}

		
	}

	@GetMapping("{idUser}/delete-{idFile}")
	public String DeleteFile(HttpSession httpSession , HttpServletRequest request , @PathVariable int idFile  
			, @PathVariable int idUser , ModelMap modelMap ){
		modelMap = GetFirstLetter(httpSession, modelMap);
		
		boolean check = 	fileService.DeleteFile(idFile);
		
		String referer = request.getHeader("Referer");
		return "redirect:/home/"+idUser ;
	}
	
	
	
	
}
