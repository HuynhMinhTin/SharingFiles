package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.service.FileService;


@Controller
@RequestMapping("/home")
public class ApiController {
	
	@Autowired
	FileService fileService;
}
