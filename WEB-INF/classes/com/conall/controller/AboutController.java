package com.conall.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.conall.dao.About;
import com.conall.service.AboutService;

@Controller
public class AboutController {
	
	private AboutService aboutService;
	
	@Autowired
	public void setAboutService(AboutService aboutService) {
		this.aboutService = aboutService;
	}
	
	@RequestMapping("/about")
	public String showAbout(Model model) {
		
		About about = aboutService.getAbout();
		
		model.addAttribute("about", about);
		
		return "about";
	}
	
	@RequestMapping(value="/editabout")
	public String edit(Model model, Principal principal) {
				
		About currentAbout = aboutService.getAbout();
		model.addAttribute("about", currentAbout);
		return "editabout";
	}
	
	@RequestMapping(value="/editaboutsubmit", method = RequestMethod.POST)
	public String editAboutSubmit(Model model, About about) {
		
		aboutService.saveOrUpdate(about);
		
		return "redirect:about";
	}
}