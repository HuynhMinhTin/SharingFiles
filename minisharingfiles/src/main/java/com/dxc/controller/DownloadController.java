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
	
//	@GetMapping("/{fileId}")
	@GetMapping
	public ResponseEntity<ByteArrayResource> download(/*@PathVariable int _id*/) {
//		dir: C:/Users/training/Desktop/login.html 
//		file want to download
		java.nio.file.Path path = Paths.get("C:/Users/training/Desktop/login.html");
		byte[] data = null;
		try {
//			get data of file by byte
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayResource resource = new ByteArrayResource(data);

		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename=" + path.getFileName().toString())				
				.contentLength(data.length).body(resource);		
	}
}
