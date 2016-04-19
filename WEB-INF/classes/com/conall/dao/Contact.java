package com.conall.dao;

public class Contact {

	private int id;
	private String email;
	private String phone;
	private String address;
	private String additional;
	
	public Contact() {
	}
	public Contact(String email, String phone, String address) {
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public Contact(String email, String phone, String address, String additional) {
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.additional = additional;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdditional() {
		return additional;
	}
	public void setAdditional(String additional) {
		this.additional = additional;
	}
	
}