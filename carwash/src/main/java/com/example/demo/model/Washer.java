package com.example.demo.model;

import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "washer")
@Data
public class Washer {

	@Id
	private String washId;
	private String firstName;//firstName
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	@NotEmpty
	@DBRef
    private Set<Role> roles;
	public Washer(String washId, String firstName, String lastName, String email, String password, String phoneNumber,
			@NotEmpty Set<Role> roles) {
		super();
		this.washId = washId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.roles = roles;
	}
	public String getWashId() {
		return washId;
	}
	public void setWashId(String washId) {
		this.washId = washId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Washer [washId=" + washId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", roles=" + roles + "]";
	}
	
	
	
}
