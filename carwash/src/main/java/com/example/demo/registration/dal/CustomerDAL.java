package com.example.demo.registration.dal;

import java.util.List;
import java.util.Set;

import com.example.demo.model.Customer;
import com.example.demo.model.Role;

public interface CustomerDAL {
	
	Customer getById(String userId);
	
	Set<Role> getRole();
	//String getPassword(String email);

}
