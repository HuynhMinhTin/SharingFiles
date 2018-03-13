package com.dxc.controller;

import java.util.List;




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
@RequestMapping("home/detail-{idFile}")
public class FileDetailController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	DownloadService downloadService;
	
	
	@GetMapping
	public String Default (ModelMap modelMap , @PathVariable int idFile) {
		
		modelMap = GetAllCategory(modelMap);
		FileEntity fileDetail = fileService.GetInfoFileDetail(idFile)	;	
		String[] parts = fileDetail.getNameFile().split("\\.");
		modelMap.addAttribute("kindFile" , parts[1]);
		modelMap.addAttribute("fileDetail", fileDetail);
		return "download";
	}
	
	public ModelMap GetAllCategory(ModelMap modelMap) {
		if(categoryService.GetCategory() != null){
			List<CategoryEntity> categoryEntities = categoryService.GetCategory();
			modelMap.addAttribute("category", categoryEntities);
		}
		
		return modelMap;
	}
	
	
	
	@PostMapping
	public String UpdateFile (ModelMap modelMap ,@PathVariable int idFile , @RequestParam String  nameUpdate 
			, @RequestParam int categoryUpdate , @RequestParam String commentUpdate , @RequestParam String descriptionUpdate){
		
		
		
		byte[] getData = downloadService.getDataById(idFile);

		FileEntity fileDetail = fileService.GetInfoFileDetail(idFile);
		//FileEntity fileUpdate = new FileEntity();
		String[] parts = fileDetail.getNameFile().split("\\.");
		
		
		
		/*CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setIdCategory(categoryUpdate);
		
		
		fileDetail.setIdCategory(categoryEntity);*/
		
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
		
	}
	
	
}
