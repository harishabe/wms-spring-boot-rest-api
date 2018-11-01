package com.wms.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	private int id;
	private String name;
	private String email;
	private String mobile;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + "]";
	}

	
}
