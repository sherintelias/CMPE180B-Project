package com.AirlineFeedback.bean;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

public class User {

	@Size(min=1,message="required")  
	private String userId;
	@Size(min=1,message="required")
	@Email(message="Please provide a valid email address")
	private String emailId;
	@Size(min=1,message="required")
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String name;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
