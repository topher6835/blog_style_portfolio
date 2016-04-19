package com.conall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conall.dao.Contact;
import com.conall.dao.ContactDao;

@Service("contactService")
public class ContactService {

	private ContactDao contactDao;

	@Autowired
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public Contact getContact() {
		return contactDao.getContact(1);
	}

	public void saveOrUpdate(Contact contact) {
		if (contact.getId() != 0) {
			contactDao.update(contact);
		}
	}

}