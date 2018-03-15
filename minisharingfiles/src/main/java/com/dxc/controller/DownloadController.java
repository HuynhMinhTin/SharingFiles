package com.dxc.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;
import com.dxc.service.DownloadService;

@Controller
@RequestMapping("file")
public class DownloadController {
	@Autowired
	DownloadService downloadService;
	
	
//	Test load information of file
	@GetMapping("/{fileId}")
	public String loadPage(@PathVariable("fileId") Integer _id){
		FileEntity file = (FileEntity) downloadService.getFileById(_id);		
		
		System.out.println("FileEntity [idFile=" + file.getIdFile() + ", idCategory=" + file.getIdCategory()
				+ ", idUser=" + file.getIdUser() + ", nameFile=" + file.getNameFile()
				+ ", sizeFile=" + file.getSizeFile() + ", commentFile=" + file.getCommentFile()
				+ ", detail=" + Arrays.toString(file.getDetail()) + ", dateCreateFile="
				+ file.getDateCreateFile() + ", statusFile=" + file.getStatusFile()
				+ ", imageLinksFile=" + file.getImageLinksFile() + ", countDowloadFile="
				+ file.getCountDowloadFile() + "]");
		
		return "download";
	}
	
	@GetMapping("{userId}/{fileId}/download")
	public ResponseEntity<?> download(@PathVariable("fileId") Integer _idFile,
			@PathVariable("userId") Integer _idUser,
			ModelMap map) {
		UserEntity user = downloadService.getUserByUserId(_idUser);
		int level = user.getIdLevel().getIdLevel();
		byte[] data = "error download".getBytes();
		long limit = 0;	
		long sizeFile = 0;
		boolean isCheckDownload = true;
		ResponseEntity<?> response;
				
//		Check login...
//		Check storage download in day
		switch (level){
		case 1:
			limit = 52428800; 		// 50MB	
			break;
		case 2:
			limit = 73400320;		// 70MB
			break;
		case 3:			
			break;
		default:
			limit = 0;
			break;
		}
		
//		Check file requested
		sizeFile = downloadService.getSizeFileById(_idFile);		
		if (sizeFile > 0){
			isCheckDownload = limitStorageDailyFilter(limit, user, sizeFile);
			
			if(isCheckDownload){
//				process getting data by its id				
				data = downloadService.getDataById(_idFile);			
				
				if (data.length == 0){
					response = new ResponseEntity<String>("<h1>Lost data</h1>", HttpStatus.EXPECTATION_FAILED);					
				} else {
//					Success to get data
//					Get extension and filename download file by split by dot sign
					String nameFile = downloadService.getFileNameById(_idFile);
					
					downloadService.updateDownloadInformation(_idFile, user.getIdUser());
					map.addAttribute("message", "Success");
					response = ResponseEntity.ok()	
							.header(HttpHeaders.CONTENT_DISPOSITION,
									"attachment;filename= " + nameFile)
							.contentLength(data.length)
							.body(data);
				}
			} else {
				map.addAttribute("message", "Your used all storage for a day");
				response = new ResponseEntity<String>("<h1>Your used all storage for a day</h1>", 
						HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
			}
		} else {
			map.addAttribute("message", "Error file");
			response = new ResponseEntity<String>("<h1>Error file</h1>", HttpStatus.BAD_REQUEST);			
		}
		
		return response;		
	}
	
	public boolean limitStorageDailyFilter(long limit, UserEntity user, long sizeFile){
		boolean allowDownload = false;
		Date lastDownload = user.getLastDownload();		// check last time download				
		long storage = 0;								// get storageDaily
		Date today = Date.valueOf(LocalDateTime.now().toLocalDate());
		
		if (user.getIdLevel().equals(3)){
			allowDownload = true;
		} else if (today.before(lastDownload)) {
			allowDownload = false;
		} else if (!today.equals(lastDownload)){
			downloadService.resetStorageDaily(user.getIdUser());
			allowDownload = true;
		} else {			
			storage = limit - user.getStorageDaily();
			if (sizeFile > storage) {
				allowDownload = false;
			} else {
				allowDownload = true;
			}
		}
		
		return allowDownload;
	}
	
}
