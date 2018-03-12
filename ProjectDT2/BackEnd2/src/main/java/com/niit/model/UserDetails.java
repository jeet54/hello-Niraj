package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="UserDetails")
@Component
public class UserDetails {

	
	
	
	public UserDetails(){
		 userEmail=null;
		 userPassword=null;
	     userAddress=null;
		 userEnabled=false;
		 userName=null;
		 userPhone=null;
		 userRole=null;
	}
	
	
public void show(UserDetails u)
{
	
	System.out.println("Emial       "  + u.getUserEmail());
	System.out.println("Password    "  + u.getUserPassword());
	System.out.println("Name        "  + u.getUserName());
	System.out.println("Address     "  + u.getUserAddress());
	System.out.println("Phone     "  + u.getUserPhone());
	System.out.println("Phone     "  + u.getUserRole());
	

	
	
	
	
}

public UserDetails(String userEmail,String userPassword, String userAddress,boolean userEnabled,
	String userName,String userPhone, String userRole )
	{

		 this.userEmail=userEmail;
		 this.userPassword=userPassword;
	     this.userAddress=userAddress;
		 this.userEnabled=userEnabled;
		 this.userName=userName;
		 this.userPhone=userPhone;
		 this.userRole=userRole;
		
	}
	

	@Id
	private String userEmail;
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	private String userPassword;
	private String userAddress;
	private boolean userEnabled;
	private String userName;
	private String userPhone;
	private String userRole;

	
	
	
	
}
