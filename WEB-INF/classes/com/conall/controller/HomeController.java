package com.conall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/resume")
	public String showResume() {
		//return "redirect:static/images/XXX.pdf";
		return "resume";
	}
	
	@RequestMapping("/photos")
	public String showPhotos() {
		return "photos";
	}
}