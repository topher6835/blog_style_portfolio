package com.conall.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conall.dao.Contact;
import com.conall.service.ContactService;

@Controller
public class ContactController {
	
	private ContactService contactService;
	
	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping("/contact")
	public String showContact(Model model) {
		
		Contact contact = contactService.getContact();
		
		model.addAttribute("contact", contact);
		
		return "contact";
	}
	
	@RequestMapping(value="/editcontact")
	public String edit(Model model, Principal principal) {
				
		Contact currentContact = contactService.getContact();
		model.addAttribute("contact", currentContact);
		return "editcontact";
	}
	
	@RequestMapping(value="/editcontactsubmit", method = RequestMethod.POST)
	public String editContactSubmit(Model model, Contact contact) {
		
		contactService.saveOrUpdate(contact);
		
		return "redirect:contact";
	}
}