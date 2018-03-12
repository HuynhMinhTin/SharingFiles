package com.dxc.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;
import com.dxc.service.GuestSevice;

@Controller
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	GuestSevice guestService3;
	FileEntity file = new FileEntity();
	//UserEntity user = new UserEntity();
//	 @GetMapping
//	 public String Default(ModelMap map) {
//	 map.addAttribute("message",
//	 "This is Get Method using @GetMapping annotation..!");
//	 return "guest";
//	 }

	@GetMapping("/showall")
	public String listguest(ModelMap modelMap) throws Exception {
		List<FileEntity> fileDetail = guestService3.GetAllInfoFile();				
		
		/*for (FileEntity s : fileDetail) {
			modelMap.addAttribute("stt", s.getIdFile());
			//modelMap.addAttribute("iduser", fileDetail.get(0).getIdUser());
			modelMap.addAttribute("sizeFile", s.getSizeFile());
			modelMap.addAttribute("nameFile", s.getNameFile());
			modelMap.addAttribute("commentFile", s.getCommentFile());
			modelMap.addAttribute("dateGreateFile", s.getDateCreateFile());
		}*/
		modelMap.addAttribute("listFiles", fileDetail);
		
		System.out.println(fileDetail);
		return "guest";
	}
}
