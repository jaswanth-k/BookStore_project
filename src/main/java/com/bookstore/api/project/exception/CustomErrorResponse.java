package com.bookstore.api.project.exception;

import java.util.Date;

public class CustomErrorResponse {
	
	private String message;
	private Integer status;
	private Date timeStamp;
	
	public CustomErrorResponse() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
