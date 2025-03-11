package com.ui.pojo;

import com.google.gson.annotations.SerializedName;

public class User {
public User(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}
private	String emailAddress;
@SerializedName("password")  
@Override
public String toString() {
	return "User [emailAddress=" + emailAddress + ", password=" + password + "]";
}
private String password;


	public String getEmailAddress() {
	return emailAddress;
}
public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
	
	

}
