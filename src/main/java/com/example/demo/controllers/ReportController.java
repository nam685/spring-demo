package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.business.ReportService;

@Controller
@RequestMapping("/report")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping
	public @ResponseBody ResponseEntity<?> getDayReport(@RequestParam(required=false) String dateString) {
		return ResponseEntity.ok(reportService.getDayReport(dateString));
	}
	
}
