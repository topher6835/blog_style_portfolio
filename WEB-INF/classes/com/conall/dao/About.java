package com.conall.dao;

public class About {
	
	private int id;
	private String about;
	
	public About() {
		
	}
	public About(int id, String about) {
		this.id = id;
		this.about = about;
	}
	public About(String about) {
		this.about = about;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}

}