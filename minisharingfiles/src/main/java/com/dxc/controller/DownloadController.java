package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.service.DownloadService;

@Controller
@RequestMapping("home/detail")
public class DownloadController {
	@Autowired
	DownloadService downloadService;
		
	
	@GetMapping("/{fileId}")
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
//				Get extension and filename download file								
				String[] nameFile = downloadService.getFileNameById(_id).split("\\.");
				
				System.out.println("filename: " + downloadService.getFileNameById(_id) 
						+ "\nnameFileSize: " + nameFile.length);
				
				filename = nameFile[0];			// get filename part
				extension = nameFile[1];		// get extension part
				resource = new ByteArrayResource(data);
				if (extension == null){
					// Warning 
				} else {
					System.out.println("extension file: " + extension);					
				}
			}
		} catch (Exception e) {
			System.out.println("Download file fail.....!!!!");
			e.printStackTrace();
		}
		
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename= " + filename  + "." + extension)
				.contentLength(data.length).body(resource);		
	}
}
