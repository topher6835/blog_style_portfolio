package com.conall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conall.dao.About;
import com.conall.dao.AboutDao;

@Service("aboutService")
public class AboutService {

	private AboutDao aboutDao;
	
	@Autowired
	public void setAboutDao(AboutDao aboutDao) {
		this.aboutDao = aboutDao;
	}
	
	public About getAbout() {
		return aboutDao.getAbout(2);
	}
	
	public void saveOrUpdate(About about) {
		if(about.getId() != 0) {
			aboutDao.update(about);
		}
	}
}