package com.example.demo.model;

import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//@EntityScan
@Document(collection="customer1")
public class Customer {
	
	@Id
	private String ID;
	//private String FirstName;//firstName
	private String Username;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}

	private String Email;
	private String Password;
	private String PhoneNumber;
	@NotEmpty
	@DBRef
    private Set<Role> roles;

  	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Customer()

	{
		
	}
	public Customer(String iD, String username, String email, String password, String phoneNumber) {
		super();
		ID = iD;
		//FirstName = firstName;
		Username = username;
		Email = email;
		Password = password;
		PhoneNumber = phoneNumber;
	}
	 
	public String getID() {
		return ID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", Username=" + Username +", Email=" + Email
				+ ", Password=" + Password + ", PhoneNumber=" + PhoneNumber + "]";
	}

}
