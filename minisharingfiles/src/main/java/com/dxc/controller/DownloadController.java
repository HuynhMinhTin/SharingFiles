package com.dxc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.service.FileService;

@Controller
@RequestMapping("/download")
public class DownloadController {
	@Autowired
	FileService fileService;
	
//	@GetMapping
//	public String loadPage(){
//		return "download";
//	}
	
	@GetMapping("/{fileId}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable("fileId") Integer _id) {
		byte[] data = "error download".getBytes();
		ByteArrayResource resource = new ByteArrayResource(data);
		
		try {
			data = fileService.getDataById(_id);			
			if (data == null){
				System.out.println("Controller fail");
				new Exception("Lost file......");
			} else {
				resource = new ByteArrayResource(data);
			}
		} catch (Exception e) {
			System.out.println("Download file fail.....!!!!");
			e.printStackTrace();
		}
		

		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename=test.pptx")				
				.contentLength(data.length).body(resource);		
	}
}
