package com.wms.beans;

import org.springframework.stereotype.Component;

@Component
public class UserActionStatus {
	private boolean status;
	private String message;
	
	public UserActionStatus()
	{
		
	}
	public UserActionStatus(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public UserActionStatus(boolean status) {
		super();
		this.status = status;
	}

	
	public UserActionStatus(String message) {
		super();
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
