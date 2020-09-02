package com.example.demo.registration.dal;

import java.util.Set;

import com.example.demo.model.Role;
import com.example.demo.model.Washer;

public interface WasherDAL {

	
Washer  getById(String userId);
	
	Set<Role> getRole();
}
