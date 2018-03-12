package com.dxc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.entitty.FileEntity;
import com.dxc.service.DownloadService;

@Controller
@RequestMapping("/file")
public class DownloadController {
	@Autowired
	DownloadService downloadService;
		
	@GetMapping("/{fileId}")
	public FileEntity loadPage(@PathVariable("fileId") Integer _id){
		FileEntity file = (FileEntity) downloadService.getFileById(_id);
		
		System.out.println("===============\nFileEntity [idFile=" + file.getIdFile() 
				+ ", idCategory=" + file.getIdCategory()
				+ ", idUser=" + file.getIdUser() 
				+ ", nameFile=" + file.getNameFile()
				+ ", sizeFile=" + file.getSizeFile() + ", commentFile=" + file.getCommentFile()
				+ ", detail=" + Arrays.toString(file.getDetail()) + ", dateCreateFile="
				+ file.getDateCreateFile() + ", statusFile=" + file.getStatusFile()
				+ ", imageLinksFile=" + file.getImageLinksFile() + ", countDowloadFile="
				+ file.getCountDowloadFile() + "]\n=========");
		
		return (FileEntity) downloadService.getFileById(_id);
	}
	
	@GetMapping("/{fileId}/download")
	public ResponseEntity<ByteArrayResource> download(@PathVariable("fileId") Integer _id) {
		byte[] data = "error download".getBytes();
		ByteArrayResource resource = new ByteArrayResource(data);
		String filename = "MFS-download-file";
		String extension = "";
		
		try {
			data = downloadService.getDataById(_id);			
			if (data == null){
				System.out.println("Controller fail");
				new Exception("Lost file......");
			} else {
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
}
