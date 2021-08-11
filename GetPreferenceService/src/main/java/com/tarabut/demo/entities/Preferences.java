package com.tarabut.demo.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern.Flag;

import org.springframework.data.annotation.Id;
 
 public class Preferences {

	@Id
	private String id;
	
	@NotEmpty(message = "The email address is required.")
	@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	private String email;
	
	@NotBlank(message = "Full Name is required.")
	private String fullname;
	
	@NotBlank(message = "Mobile Name is required.")
	private String mobileNumber;
	  
	@NotBlank(message = "Mode of communication is required.")
	private String marketingPreference;
	
	public Preferences() {
		 
	}
	
	
	public Preferences( String email, String fullname, String mobileNumber, String marketingPreference) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.mobileNumber = mobileNumber;
		this.marketingPreference = marketingPreference;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMarketingPreference() {
		return marketingPreference;
	}

	public void setMarketingPreference(String marketingPreference) {
		this.marketingPreference = marketingPreference;
	}
	
	
}
