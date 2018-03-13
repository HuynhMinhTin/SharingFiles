package com.dxc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
@RequestMapping("/file")
public class DownloadController {
	@Autowired
	DownloadService downloadService;
		
	@GetMapping("/{fileId}")
	public FileEntity loadPage(@PathVariable("fileId") Integer _id){
		FileEntity file = (FileEntity) downloadService.getFileById(_id);		
		
//		Print file information
		System.out.println("===============\nFileEntity [idFile=" + file.getIdFile() 
				+ ", idCategory=" + file.getIdCategory()
				+ ", idUser=" + file.getIdUser() 
				+ ", nameFile=" + file.getNameFile()
				+ ", sizeFile=" + file.getSizeFile() + ", commentFile=" + file.getCommentFile()
				+ ", detail=" + Arrays.toString(file.getDetail()) + ", dateCreateFile="
				+ file.getDateCreateFile() + ", statusFile=" + file.getStatusFile()
				+ ", imageLinksFile=" + file.getImageLinksFile() + ", countDowloadFile="
				+ file.getCountDowloadFile() + "]\n===============");		
//		Test
//		Date date = new Date();
		System.out.println("Today: " + new SimpleDateFormat("yyyy-MM-dd")
			.format(Calendar.getInstance()
			.getTime())
		);
		
		
		return (FileEntity) downloadService.getFileById(_id);
	}
	
	@GetMapping("/{fileId}/download")
	public ResponseEntity<ByteArrayResource> download(@PathVariable("fileId") Integer _id) {
		UserEntity user = downloadService.getUserByUserId(_id);
		int level = user.getIdLevel().getIdLevel();
		long limit = 0;
		byte[] data = "error download".getBytes();
		ByteArrayResource resource = new ByteArrayResource(data);
		String filename = "MFS-download-file";
		String extension = "";
		int userId = 26;
				
		switch (level){
		case 1:
			limit = 52428800; 		// 50MB						
		case 2:
			limit = 73400320;		// 70MB
			break;
		case 3:			
			break;
		default:
			// can't download
			break;
		}
		
		
		
				
		
		try {
			data = downloadService.getDataById(_id);			
			if (data == null){
				System.out.println("Controller fail");
				new Exception("Lost file......");
			} else {
//				Success get data
//				Get extension and filename download file by split by dot sign								
				String[] nameFile = downloadService.getFileNameById(_id).split("\\.");				
				resource = new ByteArrayResource(data);
				
				
				if (nameFile.length >= 2){					 
					filename = nameFile[0];			// get filename part
					extension = nameFile[1];		// get extension part
				} else{
					// Warning 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity
				.ok()	
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename= " + filename  + "." + extension)
				.contentLength(data.length).body(resource);		
	}
	
	public boolean limitStorageDailyFilter(long limit, UserEntity user, FileEntity file){
//		check last time download
		Date lastDownload = user.getLastDownload();
//		get storageDaily
		long storage = user.getStorageDaily();
//		check file download size
		long sizeFile = file.getSizeFile();
//		limit
		
		
		return false;
	}
}
