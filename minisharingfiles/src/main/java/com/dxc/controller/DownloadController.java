package com.dxc.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/{fileId}/download")
	public ResponseEntity<byte[]> download(@PathVariable("fileId") Integer _id) {
		UserEntity user = downloadService.getUserByUserId(26);		// 26 is user's id for test
		int level = user.getIdLevel().getIdLevel();
		byte[] data = "error download".getBytes();
		String filename = "MFS-download-file";
		String extension = ".txt";
		long limit = 0;		
		boolean isCheckDownload = true;
				
//		Check login...
//		Check storage download in day
		switch (level){
		case 1:
			limit = 52428800; 		// 50MB			
		case 2:
			limit = 73400320;		// 70MB
			break;
		case 3:			
			break;
		default:
			limit = 0;
			break;
		}		
		isCheckDownload = limitStorageDailyFilter(limit, user, downloadService.getSizeFileById(_id));
		
		if(isCheckDownload){
//		process getting data by its id
			
			data = downloadService.getDataById(_id);			
			
			if (data.length == 0){
				System.out.println("Fail to get data from database");					
			} else {
//					Success to get data
//					Get extension and filename download file by split by dot sign
				String[] nameFile = downloadService.getFileNameById(_id).split("\\.");
//					resource = new ByteArrayResource(data);					
									
				downloadService.updateDownloadInformation(_id, user.getIdUser());
				if (nameFile.length >= 2){					 
					filename = nameFile[0];			// get filename part
					extension = nameFile[1];		// get extension part
					
				} else{
					// Warning 
					System.out.println("Fail to get filename");
				}
			}
		}
		
		return ResponseEntity.ok()	
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename= " + filename  + "." + extension)
				.contentLength(data.length)
				.body(data);		
	}
	
	public boolean limitStorageDailyFilter(long limit, UserEntity user, long sizeFile){
		boolean allowDownload = false;
//		check last time download
		Date lastDownload = user.getLastDownload();
//		get storageDaily
		long storage = limit - user.getStorageDaily();
//		get today
		Date today = Date.valueOf(LocalDateTime.now().toLocalDate());
//		limit
		if (sizeFile > 0) {
			if (today.before(lastDownload)) {
				allowDownload = false;
			} else {
				if (sizeFile > storage) {
					allowDownload = false;
				} else {
					allowDownload = true;
				}
			}
		} else {
			allowDownload = false;
		}
		
		return allowDownload;
	}
	
}
