package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Role;
import com.example.demo.model.Washer;

public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
	
}