package com.example.demo.business;

import org.springframework.stereotype.Service;

@Service
public class AppService {

	public String greetings() {
		return "Welcome to the homepage";
	}
}
