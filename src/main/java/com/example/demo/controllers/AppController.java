package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.business.AppService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@GetMapping()
	public @ResponseBody String greetings() {
		return appService.greetings();
	}
}
