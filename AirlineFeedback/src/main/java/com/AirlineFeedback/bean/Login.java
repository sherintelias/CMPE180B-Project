package com.AirlineFeedback.bean;

import javax.validation.constraints.Size;

public class Login {

	@Size(min=1,message="required")  
	private String userId;
	@Size(min=1,message="required")  
	  private String password;

	  public String getUserId() {
	  return userId;
	  }

	  public void setUserId(String userId) {
	  this.userId = userId;
	  }

	  public String getPassword() {
	  return password;
	  }

	  public void setPassword(String password) {
	  this.password = password;
	  }
}
