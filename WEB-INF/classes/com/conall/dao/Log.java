package com.conall.dao;

public class Log {

	private int id;
	private String date;
	private String text;
	private String linkName;
	private String linkUrl;
	
	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Log() {
		
	}
	
	public Log(String date, String text) {
		// auto increment in database will handle id
		this.date = date;
		this.text = text;
	}

	public Log(int id, String date, String text) {
		this.id = id;
		this.date = date;
		this.text = text;
	}
	
	public Log(int id, String date, String text, String linkUrl) {
		this.id = id;
		this.date = date;
		this.text = text;
		this.linkUrl = linkUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}